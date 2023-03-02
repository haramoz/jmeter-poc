package dr.sattlers.bar.jmeterpoc;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dr.sattlers.bar.jmeterpoc.models.Order;

@RestController
public class OrderingApiController {
    @GetMapping("/menu")
    public String showMenu() {
        return "Food & Drinks!";
    }

    @PostMapping("/order")
    public ResponseEntity<String> createOrder(@RequestBody Order order) {
        // Code to insert the order into the database
        return new ResponseEntity<>("Order created successfully", HttpStatus.CREATED);
    }

    @DeleteMapping("/order/{orderId}")
    public ResponseEntity<String> cancelOrder(@PathVariable Long orderId) {
        // Code to delete the order from the database
        return new ResponseEntity<>("Order cancelled successfully", HttpStatus.OK);
    }

}
