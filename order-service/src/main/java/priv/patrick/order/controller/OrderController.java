package priv.patrick.order.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import priv.patrick.order.pojo.Order;
import priv.patrick.order.service.impl.OrderService;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping(value = "order/{orderId}")
    public Order selectOrderById(@PathVariable("orderId") Long orderId) {
        return this.orderService.selectOrderById(orderId);
    }
}

