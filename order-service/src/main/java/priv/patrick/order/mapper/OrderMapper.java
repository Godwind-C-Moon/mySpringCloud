package priv.patrick.order.mapper;

import priv.patrick.order.pojo.Order;

public interface OrderMapper {

    Order selectOrderById(Long id);

}
