package com.ddg.test.statemachine.dao;

import com.ddg.test.statemachine.entity.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 * Description:
 * ========================================================================
 * ------------------------------------------------------------------------
 *
 * @author wzj
 * @version 1.0
 * <p>
 * ========================================================================
 * @date 2022/3/4 18:49
 * @email: wangzhijie0908@gmail.com
 */
@Mapper
public interface OrderDao {

    Order selectById(Long orderId);

    Integer updateOrder(Order order);

}
