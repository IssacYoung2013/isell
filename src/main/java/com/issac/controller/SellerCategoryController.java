package com.issac.controller;

import com.issac.dataobject.ProductCategory;
import com.issac.exception.SellException;
import com.issac.form.CategoryForm;
import com.issac.service.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * author:  ywy
 * date:  2018-09-28
 * desc:
 */
@Controller
@RequestMapping("/seller/category")
public class SellerCategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ModelAndView list(Map<String, Object> map) {

        List<ProductCategory> productCategoryList = categoryService.findAll();
        map.put("categoryList", productCategoryList);
        return new ModelAndView("category/list", map);
    }

    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "categoryId", required = false) Integer categoryId,
                              Map<String, Object> map) {
        if (categoryId != null) {
            ProductCategory category = categoryService.findOne(categoryId);
            map.put("category", category);
        }
        return new ModelAndView("category/index", map);
    }

    @PostMapping("/save")
    public ModelAndView save(@Valid CategoryForm form,
                             BindingResult bindingResult,
                             Map<String, Object> map) {
        if (bindingResult.hasErrors()) {
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "/isell/seller/category/index");
            return new ModelAndView("common/error", map);
        }
        ProductCategory category = new ProductCategory();
        try {
            if (form.getCategoryId() != null) {
                category = categoryService.findOne(form.getCategoryId());
            }
            BeanUtils.copyProperties(form, category);
            categoryService.save(category);
        } catch (SellException e) {
            map.put("msg", e.getMessage());
            map.put("url", "/isell/seller/category/index");

            return new ModelAndView("common/error", map);
        }

        map.put("url", "/isell/seller/category/list");
        return new ModelAndView("common/success", map);
    }
}