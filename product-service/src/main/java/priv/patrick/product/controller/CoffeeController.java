package priv.patrick.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import priv.patrick.product.pojo.Coffee;
import priv.patrick.product.service.impl.CoffeeService;

@RestController
public class CoffeeController {

    @Autowired
    private CoffeeService coffeeService;

    /**
     * 对外提供接口服务，查询商品信息
     *
     * @param id
     * @return
     */
    @GetMapping(value = "coffee/{id}")
    public Coffee selectCoffeeById(@PathVariable("id") Long id) {
        return this.coffeeService.selectCoffeeById(id);
    }

}

