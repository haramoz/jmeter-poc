package dr.sattlers.bar.jmeterpoc.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dr.sattlers.bar.jmeterpoc.components.MenuResolver;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;

@RestController
@RequestMapping("/graphql")
public class GraphqlController {

    private final GraphQL graphQL;

    public GraphqlController(MenuResolver menuResolver) {
            TypeDefinitionRegistry typeRegistry = new TypeDefinitionRegistry();
            typeRegistry.merge(new SchemaParser().parse("type Query { menuContainsPork(itemName: String): Boolean }"));
    
            RuntimeWiring wiring = RuntimeWiring.newRuntimeWiring()
                    .type("Query", builder -> builder.dataFetcher("menuContainsPork",
                            env -> menuResolver.containsPork(env.getArgument("itemName"))))
                    .build();
    
            GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeRegistry, wiring);
            this.graphQL = GraphQL.newGraphQL(schema).build();
        }

    @PostMapping
    public ResponseEntity<Object> query(@RequestBody String query) {
        ExecutionResult executionResult = graphQL.execute(query);
        if (executionResult.getErrors().isEmpty()) {
            return ResponseEntity.ok(executionResult.getData());
        } else {
            return ResponseEntity.badRequest().body(executionResult.getErrors());
        }
    }

}
