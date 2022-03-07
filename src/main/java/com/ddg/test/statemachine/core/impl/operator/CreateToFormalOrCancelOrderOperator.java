package com.ddg.test.statemachine.core.impl.operator;

import com.ddg.test.statemachine.core.AbstractOrderOperator;
import com.ddg.test.statemachine.core.annotation.OrderOperator;
import com.ddg.test.statemachine.core.annotation.OrderProcessor;
import com.ddg.test.statemachine.enums.OrderEventEnum;
import com.ddg.test.statemachine.enums.OrderStatusEnum;
import org.springframework.stereotype.Component;

import static com.ddg.test.statemachine.enums.OrderEventEnum.CREATE_EVENT;
import static com.ddg.test.statemachine.enums.OrderEventEnum.ORDER_CANCEL;

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
public class CreateToFormalOrCancelOrderOperator extends AbstractOrderOperator {
    public CreateToFormalOrCancelOrderOperator() {
        super(OrderStatusEnum.CREATE_ORDER_STATUS.status);
    }

    @Override
    public int handleEvent(int orderStatus, OrderEventEnum orderEventEnum) {
        if (orderStatus != this.getStatus()) {
            throw new IllegalArgumentException(String.format("create operation can't handle the status: %s", orderStatus));
        }
        System.out.println("进入创建订单->真实订单or取消订单状态扭转器...");

        // 什么事件
        switch (orderEventEnum) {
            case CREATE_EVENT:
                // 这个事件之后订单的状态
                return OrderStatusEnum.FORMAL_ORDER_STATUS.status;
            case ORDER_CANCEL:
                return OrderStatusEnum.ORDER_CANCEL_STATUS.status;
            default:
                return getStatus();
        }
    }
}
