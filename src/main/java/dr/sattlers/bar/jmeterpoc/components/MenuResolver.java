package dr.sattlers.bar.jmeterpoc.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;


import dr.sattlers.bar.jmeterpoc.models.Menu;
import graphql.kickstart.tools.GraphQLResolver;

@Component
public class MenuResolver implements GraphQLResolver<Menu> {

    @Autowired
    private MongoTemplate mongoTemplate;

    public boolean containsPork(String itemName) {
        Query query = new Query();
        query.addCriteria(Criteria.where("item").is(itemName));
        query.addCriteria(Criteria.where("ingredients").in("pork"));
        return mongoTemplate.exists(query, Menu.class);
    }

}