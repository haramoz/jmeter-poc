package dr.sattlers.bar.jmeterpoc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dr.sattlers.bar.jmeterpoc.models.Menu;
import dr.sattlers.bar.jmeterpoc.models.Order;
import dr.sattlers.bar.jmeterpoc.services.OrderingApiServices;

@RestController
@EnableMongoRepositories
public class OrderingApiController {

    @Autowired
    private OrderingApiServices orderingApiServices;    

    @GetMapping("/menu")
    public ResponseEntity<List<Menu>> showMenu() {
        // var menu = menuRepository.findAll();
        List<Menu> menu = orderingApiServices.getMenu();
        return ResponseEntity.ok(menu);
    }

    @PostMapping("/order")
    public ResponseEntity<String> createOrder(@RequestBody Order order) {
        
        if(OrderingApiServices.orderCreated(order)) {
            return new ResponseEntity<>("Order created successfully", HttpStatus.CREATED);
        }

        /* TODO: process failure correctly */ 
        return new ResponseEntity<>("Order creation failed", HttpStatus.BAD_REQUEST); 
        
    }

    @DeleteMapping("/order/{orderId}")
    public ResponseEntity<String> cancelOrder(@PathVariable Long orderId) {
        // Code to delete the order from the database
        return new ResponseEntity<>("Order cancelled successfully", HttpStatus.OK);
    }

}
