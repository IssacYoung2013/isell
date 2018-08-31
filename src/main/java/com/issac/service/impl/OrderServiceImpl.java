package com.issac.service.impl;

import com.issac.dataobject.OrderDetail;
import com.issac.dataobject.OrderMaster;
import com.issac.dataobject.ProductInfo;
import com.issac.dto.CartDTO;
import com.issac.dto.OrderDTO;
import com.issac.enums.OrderStatusEnum;
import com.issac.enums.PayStatusEnum;
import com.issac.enums.ResultEnum;
import com.issac.exception.SellException;
import com.issac.repository.OrderDetailRepository;
import com.issac.repository.OrderMasterRepository;
import com.issac.repository.ProductInfoRepository;
import com.issac.service.OrderService;
import com.issac.service.ProductService;
import com.issac.util.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * author:  ywy
 * date:  2018-08-31
 * desc:
 *
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMasterRepository orderMasterRepository;

    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Autowired
    ProductService productService;

    @Override
    @Transactional
    public OrderDTO create(OrderDTO orderDTO) {

        String orderId = KeyUtil.genUniqueKey();
        BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);

        //1. 查询商品（数量，价格）
        for (OrderDetail orderDetail :
                orderDTO.getOrderDetailList()) {
           ProductInfo productInfo = productService.findOne(orderDetail.getProductId());
           if(productInfo == null) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
           }

           //2. 计算总价
           orderAmount = productInfo.getProductPrice()
                   .multiply(new BigDecimal(orderDetail.getProductQuantity()))
                   .add(orderAmount);

           // 订单详情入库
            orderDetail.setDetailId(KeyUtil.genUniqueKey());
            orderDetail.setOrderId(orderId);
            BeanUtils.copyProperties(productInfo,orderDetail);
            orderDetailRepository.save(orderDetail);
        }

        //3. 写入订单数据库（OrderMaster 和 OrderDetail）
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderDTO,orderMaster);
        orderMaster.setOrderAmount(orderAmount);
        orderMaster.setOrderId(orderId);
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMasterRepository.save(orderMaster);

        //4. 扣库存
        List<CartDTO> cartDTOList = orderDTO.getOrderDetailList().stream()
                .map(e -> new CartDTO(e.getProductId(),e.getProductQuantity()))
                .collect(Collectors.toList());
        productService.decreaseStock(cartDTOList);

        return orderDTO;
    }

    @Override
    public OrderDTO findOne(String orderId) {
        return null;
    }

    @Override
    public Page<OrderDTO> findList(String buyerOpenid, Pageable pageable) {
        return null;
    }

    @Override
    public OrderDTO cancel(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO finish(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO paid(OrderDTO orderDTO) {
        return null;
    }
}