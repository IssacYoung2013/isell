package com.issac.enums;

import lombok.Getter;

/**
 *
 * author:  ywy
 * date:  2018-08-30
 * desc:
 *
 */
@Getter
public enum ProductStatusEnum {
    UP(0,"在架"),
    DOWN(1,"下架");

    private Integer code;

    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
