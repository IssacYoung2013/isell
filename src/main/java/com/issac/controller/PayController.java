package com.issac.controller;

import com.issac.dto.OrderDTO;
import com.issac.enums.ResultEnum;
import com.issac.exception.SellException;
import com.issac.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 *
 * @author Issac
 *  *   @date    2018-09-09
 * @desc
 */
@Controller
@RequestMapping("/pay")
public class PayController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/create")
    public void create(@RequestParam("orderId") String orderId,
                       @RequestParam("returnUrl") String returnUrl) {

        // 1. 查询订单
        OrderDTO orderDTO = orderService.findOne(orderId);
        if(orderDTO == null) {
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
    }
}
