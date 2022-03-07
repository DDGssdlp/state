package com.ddg.test.statemachine.controller;

import com.ddg.test.statemachine.core.OrderStateManager;
import com.ddg.test.statemachine.dao.OrderDao;
import com.ddg.test.statemachine.entity.Order;
import com.ddg.test.statemachine.enums.OrderEventEnum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 * ========================================================================
 * ------------------------------------------------------------------------
 *
 * @author wzj
 * @version 1.0
 * <p>
 * ========================================================================
 * @date 2022/3/4 16:10
 * @email: wangzhijie0908@gmail.com
 */
@RestController
public class OrderController {

    @Autowired
    private OrderStateManager manager;

    @Autowired
    private OrderDao orderDao;

    @GetMapping("/createOrder")
    @Transactional
    public Order orderCreate() {
        Order order = orderDao.selectById(1L);
        manager.handleOrder(order, OrderEventEnum.CREATE_EVENT);
        return order;
    }

    @GetMapping("/payOrder")
    public Order payOrder() {
        Order order = orderDao.selectById(1L);
        manager.handleOrder(order, OrderEventEnum.NEED_PAY);
        return order;
    }
}
