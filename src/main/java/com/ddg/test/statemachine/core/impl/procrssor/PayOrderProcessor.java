package com.ddg.test.statemachine.core.impl.procrssor;

import com.ddg.test.statemachine.core.AbstractOrderProcessor;
import com.ddg.test.statemachine.core.annotation.OrderProcessor;
import com.ddg.test.statemachine.dao.OrderDao;
import com.ddg.test.statemachine.entity.Order;
import com.ddg.test.statemachine.enums.OrderEventEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Description:
 * ========================================================================
 * ------------------------------------------------------------------------
 *
 * @author wzj
 * @version 1.0
 * <p>
 * ========================================================================
 * @date 2022/3/4 16:28
 * @email: wangzhijie0908@gmail.com
 */
@Component
@OrderProcessor
public class PayOrderProcessor extends AbstractOrderProcessor {

    public PayOrderProcessor() {
        super(OrderEventEnum.NEED_PAY.status);
    }

    @Autowired
    private OrderDao orderDao;

    public boolean process(Order order, Integer resStatus, Object... params) {
        // 取消订单
        order.setOrderStatus(resStatus);
        Integer integer = orderDao.updateOrder(order);
        System.out.println("进入支付订单后处理器...");
        return true;

    }
}
