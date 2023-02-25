package dr.sattlers.bar.jmeterpoc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderingApiController {
    @GetMapping("/menu")
    public String showMenu() {
        return "Food & Drinks!";
    }
}
