package com.issac.repository;

import com.issac.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * author:  ywy
 * date:  2018-08-30
 * desc:
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {

    List<ProductInfo> findProductByProductStatus(Integer productStatus);


}