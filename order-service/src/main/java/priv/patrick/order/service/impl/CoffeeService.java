package priv.patrick.order.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import priv.patrick.order.pojo.Coffee;

@Service
public class CoffeeService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${interface.pcPrefix}")
    private String pcPrefix;

    @Autowired
    private priv.patrick.order.service.integration.CoffeeService coffeeService;

    @HystrixCommand(fallbackMethod = "selectCoffeeByIdFallback")
    public Coffee selectCoffeeById(Long id) {
        // 这种方式必须先开启负载均衡@LoadBalanced
        String itemUrl = pcPrefix + "coffee/{id}";
        return this.restTemplate.getForObject(itemUrl, Coffee.class ,id);
    }

    public Coffee selectCoffeeByIdFeign(Long id){
        return this.coffeeService.selectCoffeeById(id);
    }

    private Coffee selectCoffeeByIdFallback(Long id) {
        System.out.println("触发降级.");
        return new Coffee();
    }
}

