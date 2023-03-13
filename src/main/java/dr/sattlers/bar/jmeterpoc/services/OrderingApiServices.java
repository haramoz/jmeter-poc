package dr.sattlers.bar.jmeterpoc.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dr.sattlers.bar.jmeterpoc.models.Menu;
import dr.sattlers.bar.jmeterpoc.models.Order;
import dr.sattlers.bar.jmeterpoc.repository.MenuRepository;
import dr.sattlers.bar.jmeterpoc.repository.OrderRepository;

@Service
public class OrderingApiServices {

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private static OrderRepository orderRepository;

    public List<Menu> getMenu() {
        var menu = menuRepository.findAll();
        return menu; // todo exception handling
    }

    public static boolean orderCreated(Order order) {
        // Code to insert the order into the database
        if(orderRepository.insert(order) != null) {

        }
        return false;
    }
    
}
