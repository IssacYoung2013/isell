package com.issac.exception;

import com.issac.enums.ResultEnum;

/**
 * author:  ywy
 * date:  2018-08-31
 * desc:
 */
public class SellException extends RuntimeException {

    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());

        this.code = resultEnum.getCode();
    }


    public SellException(Integer code,String msg) {
        super(msg);
        this.code = code;
    }
}