package com.ddg.test.statemachine.core.impl.procrssor;

import com.ddg.test.statemachine.core.AbstractOrderProcessor;
import com.ddg.test.statemachine.core.annotation.OrderProcessor;
import com.ddg.test.statemachine.entity.Order;
import com.ddg.test.statemachine.enums.OrderEventEnum;
import com.ddg.test.statemachine.enums.OrderStatusEnum;
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
public class CancelOrderProcessor extends AbstractOrderProcessor {

    public CancelOrderProcessor() {
        super(OrderEventEnum.ORDER_CANCEL.status);
    }

    public boolean process(Order order, Integer resStatus, Object... params) {
        // 取消订单
        System.out.println("进入取消订单后处理器...");
        return true;

    }
}
