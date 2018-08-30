package com.issac.repository;

import com.issac.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * author:  ywy
 * date:  2018-08-29
 * desc:
 */
public interface ProductCategoryRespository extends JpaRepository<ProductCategory, Integer> {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}