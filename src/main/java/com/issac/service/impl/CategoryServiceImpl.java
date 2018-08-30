package com.issac.service.impl;

import com.issac.dataobject.ProductCategory;
import com.issac.repository.ProductCategoryRespository;
import com.issac.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * author:  ywy
 * date:  2018-08-29
 * desc:
 *
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private ProductCategoryRespository respository;

    @Override
    public ProductCategory findOne(Integer categoryId) {
        return respository.findOne(categoryId);
    }

    @Override
    public List<ProductCategory> findAll() {
        return respository.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return respository.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return respository.save(productCategory);
    }
}