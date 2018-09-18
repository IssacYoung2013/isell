package com.issac.service.impl;

import com.issac.dto.OrderDTO;
import com.issac.service.OrderService;
import com.issac.service.PayService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 *
 * author:  ywy
 * date:  2018-09-11
 * desc:
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class PayServiceImplTest {

    @Autowired
    private PayService payService;

    @Autowired
    private  OrderService orderService;

    @Test
    public void create() {
        OrderDTO orderDTO = orderService.findOne("15369830460569924981");
        payService.create(orderDTO);
    }

    @Test
    public void refund() {
        OrderDTO orderDTO = orderService.findOne("15369830460569924981");
        payService.refund(orderDTO);
    }
}