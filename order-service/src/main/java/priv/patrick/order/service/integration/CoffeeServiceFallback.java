package priv.patrick.order.service.integration;

import org.springframework.stereotype.Component;
import priv.patrick.order.pojo.Coffee;


@Component
public class CoffeeServiceFallback  implements CoffeeService {

    @Override
    public Coffee selectCoffeeById(Long id) {
        return new Coffee();
    }
}
