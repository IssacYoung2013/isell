package com.issac.form;

import lombok.Data;

/**
 *
 * author:  ywy
 * date:  2018-09-28
 * desc:
 *
 */
@Data
public class CategoryForm {

    private Integer categoryId;

    /**
     * 类目名字
     */
    private String categoryName;

    /**
     * 类目编号
     */
    private Integer categoryType;
}