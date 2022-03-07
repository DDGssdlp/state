package com.ddg.test.statemachine.core.impl.operator;

import com.ddg.test.statemachine.core.AbstractOrderOperator;
import com.ddg.test.statemachine.core.annotation.OrderOperator;
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
 * @date 2022/3/4 16:20
 * @email: wangzhijie0908@gmail.com
 */
@Component
@OrderOperator
public class FormalToPayOrderOperator extends AbstractOrderOperator {
    public FormalToPayOrderOperator() {
        super(OrderStatusEnum.FORMAL_ORDER_STATUS.status);
    }

    @Override
    public int handleEvent(int orderStatus, OrderEventEnum orderEventEnum) {
        if (orderStatus != this.getStatus()) {
            throw new IllegalArgumentException(String.format("create operation can't handle the status: %s", orderStatus));
        }
        System.out.println("进入创建真实订单->支付订单状态扭转器...");

        // 什么事件
        switch (orderEventEnum) {
            case NEED_PAY:
                // 这个事件之后订单的状态
                return OrderStatusEnum.PAY_DONE_STATUS.status;
            case ORDER_CANCEL:
                return OrderStatusEnum.ORDER_CANCEL_STATUS.status;
            default:
                return getStatus();
        }
    }
}
