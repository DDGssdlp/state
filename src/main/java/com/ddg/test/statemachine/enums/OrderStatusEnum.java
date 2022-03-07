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

public enum  OrderStatusEnum {

    // 加入购物车--> 下单 或者 --> 取消订单
    CREATE_ORDER_STATUS(1, "创建订单"),
    FORMAL_ORDER_STATUS(2, "正式订单"),
    NEED_PAY_STATUS(3, "待支付"),
    PAY_DONE_STATUS(4, "已支付"),
    ORDER_FINISHED_STATUS(5, "订单已完成"),

    ORDER_CANCEL_STATUS(6, "订单已取消");

    OrderStatusEnum(Integer status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public Integer status;

    public String desc;
}
