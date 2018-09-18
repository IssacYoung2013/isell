package com.issac.controller;

import com.issac.dto.OrderDTO;
import com.issac.enums.ResultEnum;
import com.issac.exception.SellException;
import com.issac.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * author:  ywy
 * date:  2018-09-14
 * desc:
 */
@Controller
@RequestMapping("/seller/order")
@Slf4j
public class SellOrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 订单列表
     *
     * @param page 第几页
     * @param size 一页多少条
     * @return
     */
    @GetMapping("list")
    public ModelAndView list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "size", defaultValue = "10") Integer size,
                             Map<String, Object> map) {
        PageRequest request = new PageRequest(page - 1, size);

        Page<OrderDTO> orderDTOPage = orderService.findList(request);
        map.put("orderDTOPage", orderDTOPage);
        map.put("currentPage", page);
        map.put("size", size);
        return new ModelAndView("order/list", map);
    }

    /**
     * 取消订单
     *
     * @param orderId
     * @return
     */
    @GetMapping("/cancel")
    public ModelAndView cancel(@RequestParam("orderId") String orderId,
                               Map<String, Object> map) {

        try {
            OrderDTO orderDTO = orderService.findOne(orderId);
            orderService.cancel(orderDTO);

        } catch (SellException e) {
            log.error("【卖家取消订单】发生异常e={}", e);
            map.put("msg", e.getMessage());
            map.put("url", "/isell/seller/order/list");
            return new ModelAndView("common/error", map);
        }

        map.put("msg", ResultEnum.ORDER_CANCELL_SUCCESS.getMessage());
        map.put("url", "/isell/seller/order/list");

        return new ModelAndView("common/success");
    }

    /**
     * 订单详情
     *
     * @param orderId
     * @param map
     * @return
     */
    @GetMapping("/detail")
    public ModelAndView detail(@RequestParam("orderId") String orderId,
                               Map<String, Object> map) {
        OrderDTO orderDTO;

        try {
            orderDTO = orderService.findOne(orderId);
        } catch (SellException e) {
            log.error("【卖家取消订单】发生异常e={}", e);
            map.put("msg", e.getMessage());
            map.put("url", "/isell/seller/order/list");
            return new ModelAndView("common/error", map);
        }
        map.put("orderDTO", orderDTO);
        return new ModelAndView("order/detail", map);
    }

    /**
     * 完结订单
     *
     * @param orderId
     * @return
     */
    @GetMapping("/finish")
    public ModelAndView finish(@RequestParam("orderId") String orderId,
                               Map<String, Object> map) {

        try {
            OrderDTO orderDTO = orderService.findOne(orderId);
            orderService.finish(orderDTO);

        } catch (SellException e) {
            log.error("【卖家完结订单】发生异常e={}", e);
            map.put("msg", e.getMessage());
            map.put("url", "/isell/seller/order/list");
            return new ModelAndView("common/error", map);
        }

        map.put("msg", ResultEnum.ORDER_CANCELL_SUCCESS.getMessage());
        map.put("url", "/isell/seller/order/list");

        return new ModelAndView("common/success");
    }
}