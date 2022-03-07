package com.ddg.test.statemachine.core.impl.procrssor;

import com.ddg.test.statemachine.core.AbstractOrderProcessor;
import com.ddg.test.statemachine.core.annotation.OrderProcessor;
import com.ddg.test.statemachine.dao.OrderDao;
import com.ddg.test.statemachine.entity.Order;
import com.ddg.test.statemachine.enums.OrderEventEnum;
import com.ddg.test.statemachine.enums.OrderStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Description:
 * ========================================================================
 * ------------------------------------------------------------------------
 *
 * @author wzj
 * @version 1.0
 * <p>
 * ========================================================================
 * @date 2022/3/4 16:30
 * @email: wangzhijie0908@gmail.com
 */
@Component
@OrderProcessor
public class CreateOrderProcessor extends AbstractOrderProcessor {

    public CreateOrderProcessor() {
        super(OrderEventEnum.CREATE_EVENT.status);
    }

    @Autowired
    private OrderDao orderDao;

    @Override
    public boolean process(Order order, Integer resStatus, Object... params) {
        // TODO 创建订单对应的数据库修改，mq发送等操作，可以在此处process方法中完成
        System.out.println("进入创建订单后处理器...");
        order.setOrderStatus(resStatus);
        Integer integer = orderDao.updateOrder(order);

       // int i = 1 / 0;
        return integer > 0;
    }
}
