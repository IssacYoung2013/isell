package com.issac.service;

import com.issac.dto.OrderDTO;
import com.lly835.bestpay.model.PayResponse;

/**
 *
 *
 * @author Issac
 *  *   @date    2018-09-09
 * @desc
 */
public interface PayService {

    PayResponse create(OrderDTO orderDTO);
}
