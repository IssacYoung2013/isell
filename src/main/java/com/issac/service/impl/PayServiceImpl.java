package com.issac.service.impl;

import com.issac.dto.OrderDTO;
import com.issac.service.PayService;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;

/**
 * @author Issac
 *  *   @date    2018-09-09
 * @desc
 */
public class PayServiceImpl implements PayService {


    @Override
    public void create(OrderDTO orderDTO) {
        BestPayServiceImpl bestPayService = new BestPayServiceImpl();

    }
}
