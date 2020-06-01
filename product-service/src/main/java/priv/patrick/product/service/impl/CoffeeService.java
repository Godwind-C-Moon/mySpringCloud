package priv.patrick.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.patrick.product.mapper.CoffeeMapper;
import priv.patrick.product.pojo.Coffee;

@Service
public class CoffeeService {

    @Autowired
    private CoffeeMapper coffeeMapper;

    public Coffee selectCoffeeById(Long id) {
        return coffeeMapper.selectById(id);
    }

}

