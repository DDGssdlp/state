package com.ddg.test.statemachine.core;

import com.ddg.test.statemachine.entity.Order;
import lombok.Data;


@Data
public abstract class AbstractOrderProcessor {

    int status;

    public AbstractOrderProcessor(int status) {
        this.status = status;
    }

    public abstract boolean process(Order order, Integer resStatus, Object... params);
}
