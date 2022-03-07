package com.ddg.test.statemachine.core;


import com.ddg.test.statemachine.entity.Order;
import com.ddg.test.statemachine.enums.OrderEventEnum;
import com.ddg.test.statemachine.enums.OrderStatusEnum;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 订单状态流转管理器--状态机核心组件
 **/
@Component
public class OrderStateManager {

    Map<Integer, AbstractOrderOperator> orderOperatorMaps = new HashMap<Integer, AbstractOrderOperator>();

    Map<Integer, AbstractOrderProcessor> orderProcessorMaps = new HashMap<Integer, AbstractOrderProcessor>();

    public OrderStateManager() { }

    /**
     *状态流转方法

     * @param event 流转的订单操作事件

     * @return 扭转后的订单状态
     */
    public int handleOrder( Order order, OrderEventEnum event) {
        Long orderId = order.getOrderId();
        Integer status = order.getOrderStatus();
        if (this.isFinalStatus(status)) {
            throw new IllegalArgumentException("handle event can't process final state order.");
        }
        // 获取对应处理器,根据入参状态和时间获取订单流转的结果状态
        AbstractOrderOperator abstractOrderOperator = this.getStateOperator(status);
        int resState = abstractOrderOperator.handleEvent(status, event);
        // 得到结果状态，在对应的processor中处理订单数据及其相关信息
        if(resState == status){
            throw new IllegalStateException("订单状态不对");
        }
        AbstractOrderProcessor orderProcessor = this.getOrderProcessor(event);
        if (!orderProcessor.process(order, resState)) {
            throw new IllegalStateException(String.format("订单状态流转失败，订单id:%s", orderId));
        }
        return resState;
    }

    /**
     * 根据入参状态枚举实例获取对应的状态处理器
     * @param
     * @param
     * @return
     */
    private AbstractOrderOperator getStateOperator(int status) {
        AbstractOrderOperator operator = this.orderOperatorMaps.get(status);
        if (null == operator) {
            throw new IllegalArgumentException(String.format("can't find proper operator. The parameter state :%s",
                    status));
        }
        return operator;
    }

    /**
     * 根据入参状态枚举实例获取对应的状态后处理器
     * @param event event
     * @return
     */
    private AbstractOrderProcessor getOrderProcessor(OrderEventEnum event) {
        AbstractOrderProcessor processor = this.orderProcessorMaps.get(event.status);
        if (null == processor) {
            throw new IllegalArgumentException(String.format("can't find proper processor. The parameter state :%s", event.toString()));
        }
        return processor;
    }


    /**
     * 判断是不是已完成订单
     * @param status 订单状态码
     * @return
     */
    private boolean isFinalStatus(int status) {
        return OrderStatusEnum.ORDER_FINISHED_STATUS.status == status;
    }

}
