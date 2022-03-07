package com.ddg.test.statemachine.core;


import com.ddg.test.statemachine.enums.OrderEventEnum;

import com.ddg.test.statemachine.enums.OrderStatusEnum;
import lombok.Data;


@Data
public abstract class AbstractOrderOperator {

    int status;

    public AbstractOrderOperator(int status) {
        this.status = status;
    }

    public abstract int handleEvent(int orderStatus, OrderEventEnum orderStatusEnum);


}
