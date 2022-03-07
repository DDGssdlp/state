package com.ddg.test.statemachine.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Description:
 * ========================================================================
 * ------------------------------------------------------------------------
 *
 * @author wzj
 * @version 1.0
 * <p>
 * ========================================================================
 * @date 2022/3/4 18:50
 * @email: wangzhijie0908@gmail.com
 */
@Data
@AllArgsConstructor
public class Order {

    private Long orderId;
    private Integer orderStatus;
}
