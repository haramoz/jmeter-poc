package dr.sattlers.bar.jmeterpoc.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import dr.sattlers.bar.jmeterpoc.models.Order;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {
    List<Order> findByCustomerName(String customerName);
}
    