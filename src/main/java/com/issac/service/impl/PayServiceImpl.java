package com.issac.service.impl;

import com.issac.dto.OrderDTO;
import com.issac.service.PayService;
import com.lly835.bestpay.model.PayRequest;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Issac
 *  *   @date    2018-09-09
 * @desc
 */
public class PayServiceImpl implements PayService {


    @Autowired
    private BestPayServiceImpl bestPayService;

    @Override
    public void create(OrderDTO orderDTO) {
        PayRequest payRequest = new PayRequest();
        bestPayService.pay(payRequest);
    }
}
