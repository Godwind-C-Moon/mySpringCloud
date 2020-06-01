package priv.patrick.order.service.integration;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import priv.patrick.order.pojo.Coffee;


@FeignClient(value = "product-service", contextId ="coffeeService")
public interface CoffeeService {
    @RequestMapping(value = "/item/{id}",method = RequestMethod.GET)
    Coffee selectCoffeeById(@PathVariable("id") Long id);
}
