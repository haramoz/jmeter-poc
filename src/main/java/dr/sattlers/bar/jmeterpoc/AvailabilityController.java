package dr.sattlers.bar.jmeterpoc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AvailabilityController {
    @GetMapping("/test")
    public boolean showMenu() {
        return true;
    }
}
