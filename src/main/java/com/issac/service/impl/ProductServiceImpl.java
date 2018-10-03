package com.issac.service.impl;


import com.issac.dataobject.ProductInfo;
import com.issac.dto.CartDTO;
import com.issac.enums.ProductStatusEnum;
import com.issac.enums.ResultEnum;
import com.issac.exception.SellException;
import com.issac.repository.ProductInfoRepository;
import com.issac.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 * author:  ywy
 * date:  2018-08-30
 * desc:
 *
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository repository;

    @Override
    public ProductInfo findOne(String productId) {
        return repository.findOne(productId);
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return repository.findProductByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return repository.save(productInfo);
    }

    @Override
    @Transactional
    public void increaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO :cartDTOList) {
            ProductInfo productInfo = repository.findOne(cartDTO.getProductId());
            if(productInfo == null) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }

            Integer result = productInfo.getProductStock() + cartDTO.getProductQuantity();

            productInfo.setProductStock(result);

            repository.save(productInfo);

        }
    }

    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDto :
                cartDTOList) {
            ProductInfo productInfo = repository.findOne(cartDto.getProductId());
            if(productInfo == null) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }

            Integer result = productInfo.getProductStock() - cartDto.getProductQuantity();
            if(result < 0) {
                throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
            }

            productInfo.setProductStock(result);

            repository.save(productInfo);
        }
    }

    @Override
    public ProductInfo onSale(String productId) {
        ProductInfo productInfo = repository.findOne(productId);
        if(productInfo == null) {
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        }
        if(productInfo.getProductStatusEnum() == ProductStatusEnum.UP) {
            throw new SellException(ResultEnum.PRODUCT_STATUS_ERROR);
        }

        // 更新
        productInfo.setProductStatus(ProductStatusEnum.UP.getCode());
        repository.save(productInfo);

        return productInfo;
    }

    @Override
    public ProductInfo offSale(String productId) {
        ProductInfo productInfo = repository.findOne(productId);
        if(productInfo == null) {
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        }
        if(productInfo.getProductStatusEnum() == ProductStatusEnum.DOWN) {
            throw new SellException(ResultEnum.PRODUCT_STATUS_ERROR);
        }

        // 更新
        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());
        repository.save(productInfo);

        return productInfo;
    }
}