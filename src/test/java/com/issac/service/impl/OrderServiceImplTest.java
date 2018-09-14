package com.issac.service.impl;

import com.issac.dataobject.OrderDetail;
import com.issac.dto.OrderDTO;
import com.issac.enums.OrderStatusEnum;
import com.issac.enums.PayStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 *
 * author:  ywy
 * date:  2018-08-31
 * desc:
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {

    private final String buyeropenid = "110110";

    private final String ORDER_ID = "15360216929005316639";

    @Autowired
    OrderServiceImpl orderService;

    @Test
    public void create() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("Issac");
        orderDTO.setBuyerAddress("南北商务港");
        orderDTO.setBuyerPhone("12345678911");
        orderDTO.setBuyerOpenid(buyeropenid);

        List<OrderDetail> orderDetailList = new ArrayList<>();

        OrderDetail o1 = new OrderDetail();
        o1.setProductId("123457");
        o1.setProductQuantity(2);
        orderDetailList.add(o1);

        OrderDetail o2 = new OrderDetail();
        o2.setProductId("123456");
        o2.setProductQuantity(1);
        orderDetailList.add(o2);

        orderDTO.setOrderDetailList(orderDetailList);

        OrderDTO result = orderService.create(orderDTO);
        log.info("【创建订单】 result={}",result);

        Assert.assertNotNull(result);
    }

    @Test
    public void findOne() {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        log.info("【查询单个订单】 result={}",orderDTO);
        Assert.assertEquals(orderDTO.getOrderId(),ORDER_ID);
    }

    @Test
    public void findList() {
        Page<OrderDTO> orderDTOPage = orderService.findList(buyeropenid,new PageRequest(0,10));
        Assert.assertNotEquals(0,orderDTOPage.getTotalElements());
    }

    @Test
    public void cancel() {

        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        OrderDTO result = orderService.cancel(orderDTO);
        Assert.assertEquals(result.getOrderStatus(), OrderStatusEnum.CANCELL.getCode());
    }

    @Test
    public void finish() {

        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        OrderDTO result = orderService.finish(orderDTO);
        Assert.assertEquals(result.getOrderStatus(), OrderStatusEnum.FINISHED.getCode());
    }

    @Test
    public void paid() {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        OrderDTO result = orderService.paid(orderDTO);
        Assert.assertEquals(result.getPayStatus(), PayStatusEnum.SUCCESS.getCode());
    }

    @Test
    public void list() {
        Page<OrderDTO> orderDTOPage = orderService.findList(new PageRequest(0,10));
        Assert.assertNotEquals(0,orderDTOPage.getTotalElements());
    }
}