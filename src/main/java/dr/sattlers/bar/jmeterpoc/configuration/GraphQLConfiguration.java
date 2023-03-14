package dr.sattlers.bar.jmeterpoc.configuration;

import java.io.IOException;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dr.sattlers.bar.jmeterpoc.components.MenuResolver;

@Configuration
public class GraphQLConfiguration {

    @Autowired
    private MenuResolver menuResolver;

    @Bean
    public GraphQLSchema schema() throws IOException {
        TypeDefinitionRegistry typeRegistry = new TypeDefinitionRegistry();
        SchemaParser schemaParser = new SchemaParser();
        typeRegistry.merge(schemaParser.parse(getClass().getResourceAsStream("schema.graphqls")));

        RuntimeWiring runtimeWiring = RuntimeWiring.newRuntimeWiring()
                .type("Menu", builder -> builder.dataFetcher("containsPork", env -> {
                    String itemName = env.getArgument("itemName");
                    return menuResolver.containsPork(itemName);
                }))
                .build();

        SchemaGenerator schemaGenerator = new SchemaGenerator();
        return schemaGenerator.makeExecutableSchema(typeRegistry, runtimeWiring);
    }
}
