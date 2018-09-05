package com.issac.service;

import com.issac.dto.OrderDTO;

/**
 *
 * author:  ywy
 * date:  2018-09-04
 * desc:
 *
 */
public interface BuyerService {

    // 查询一个订单
    OrderDTO findOrderOne(String openid, String orderId);

    // 取消订单
    OrderDTO cancelOrder(String openid, String orderId);
}