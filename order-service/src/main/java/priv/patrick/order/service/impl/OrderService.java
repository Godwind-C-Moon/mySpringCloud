package priv.patrick.order.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.patrick.order.mapper.OrderMapper;
import priv.patrick.order.pojo.Coffee;
import priv.patrick.order.pojo.Order;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private CoffeeService coffeeService;
    @Autowired
    private OrderMapper orderMapper;

    public Order selectOrderById(Long orderId) {
        Order order = orderMapper.selectOrderById(orderId);
        List<Coffee> items = order.getItems();
        for (Coffee coffee : items) {
            // 通过商品微服务查询商品详细数据
            Coffee result = this.coffeeService.selectCoffeeById(coffee.getId());
            BeanUtils.copyProperties(result,coffee);
//            Item item = this.itemService.feignQueryItemByid(orderDetail.getItem().getId());
        }
        return order;
    }

}

