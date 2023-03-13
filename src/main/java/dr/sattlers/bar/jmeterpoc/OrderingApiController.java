package dr.sattlers.bar.jmeterpoc;

import java.util.Collections;
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

import dr.sattlers.bar.jmeterpoc.exception.BarException;
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
        try{
            List<Menu> menu = orderingApiServices.getMenu();
            return ResponseEntity.ok(menu);
        }
        catch (BarException e) {
            String errorMessage = "Error getting menu: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                             .body(Collections.singletonList(new Menu(errorMessage)));
        }
        
    }

    @PostMapping("/order")
    public ResponseEntity<String> createOrder(@RequestBody Order order) {
        
        try {
            if (OrderingApiServices.orderCreated(order)) {
                return new ResponseEntity<>("Order created successfully", HttpStatus.CREATED);
            }
        } catch (BarException e) {
            String errorMessage = "Error creating order: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body(errorMessage);
        } catch (Exception e) {
            String errorMessage = "Unexpected error creating order: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body(errorMessage);
        }   
        return new ResponseEntity<>("Order creation failed", HttpStatus.BAD_REQUEST); 
        
    }

    @DeleteMapping("/order/{orderId}")
    public ResponseEntity<String> cancelOrder(@PathVariable Long orderId) {
        // Code to delete the order from the database
        return new ResponseEntity<>("Order cancelled successfully", HttpStatus.OK);
    }

}
