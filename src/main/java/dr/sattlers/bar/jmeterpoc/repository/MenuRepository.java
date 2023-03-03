package dr.sattlers.bar.jmeterpoc.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import dr.sattlers.bar.jmeterpoc.models.Menu;

@Repository
public interface MenuRepository extends MongoRepository<Menu, String> {
}
    