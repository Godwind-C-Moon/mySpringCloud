package priv.patrick;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import priv.patrick.order.OrderServiceApplication;
import priv.patrick.order.pojo.Order;
import priv.patrick.order.service.impl.OrderService;

@SpringBootTest(classes = OrderServiceApplication.class)
public class OrderTest {
    @Autowired
    private OrderService orderService;

    @Test
    public void test1(){
        Order order = this.orderService.selectOrderById(1L);
        System.out.println(order.toString());
    }
}
