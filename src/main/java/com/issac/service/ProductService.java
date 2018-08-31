package com.issac.service;

import com.issac.dataobject.ProductInfo;
import com.issac.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 *
 * author:  ywy
 * date:  2018-08-30
 * desc:
 *
 */
public interface ProductService {

    ProductInfo findOne(String productId);

    Page<ProductInfo> findAll(Pageable pageable);

    /**
     * 查询在架的商品
     * @return
     */
    List<ProductInfo> findUpAll();

    ProductInfo save(ProductInfo productInfo);

    // 加库存
    void increaseStock(List<CartDTO> cartDTOList);

    // 减库存
    void decreaseStock(List<CartDTO> cartDTOList);
}