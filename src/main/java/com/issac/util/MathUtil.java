package com.issac.util;

/**
 * author:  ywy
 * date:  2018-09-14
 * desc:
 */
public class MathUtil {

    private static final Double MONEY_RANGE = 0.01;

    /**
     * 比较金额是否相等
     *
     * @param d1
     * @param d2
     * @return
     */
    public static Boolean equals(Double d1, Double d2) {
        Double result = Math.abs(d1 - d2);
        if (result < MONEY_RANGE) {
            return true;
        }

        return false;
    }
}