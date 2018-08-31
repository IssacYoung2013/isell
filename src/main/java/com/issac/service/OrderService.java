package com.issac.service;

import com.issac.dataobject.OrderMaster;
import com.issac.dto.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * author:  ywy
 * date:  2018-08-31
 * desc:
 *
 */
public interface OrderService {
    /**
    * 创建订单
     */
    OrderDTO create(OrderDTO orderDTO);

    /**
     * 查询单个订单
     */
    OrderDTO findOne(String orderId);

    /**
     * 查询订单列表
     */
    Page<OrderDTO> findList(String buyerOpenid, Pageable pageable);

    /**
     * 取消订单
     */
    OrderDTO cancel(OrderDTO orderDTO);

    /**
     * 完结订单
     */
    OrderDTO finish(OrderDTO orderDTO);

    /**
     * 支付订单
     */
    OrderDTO paid(OrderDTO orderDTO);

}