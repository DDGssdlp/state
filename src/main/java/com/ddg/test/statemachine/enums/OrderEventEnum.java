package com.ddg.test.statemachine.enums;

/**
 * Description:
 * ========================================================================
 * ------------------------------------------------------------------------
 *
 * @author wzj
 * @version 1.0
 * <p>
 * ========================================================================
 * @date 2022/3/4 16:02
 * @email: wangzhijie0908@gmail.com
 */

public enum OrderEventEnum {


    CREATE_EVENT(1, "创建订单"),
    NEED_PAY(2, "支付订单"),
    ORDER_CANCEL(3, "取消订单");

    OrderEventEnum(Integer status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public Integer status;

    public String desc;
}
