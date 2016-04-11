package com.cn.furious.utils;

import java.math.BigDecimal;

/**
 * Created by zhuminghua on 14-9-2.
 */
public class FormatUtil {
    /**
     * 小数取精度，四舍五入
     * @return
     */
    public static double getScale(double value, int scale) {
        if(Double.isInfinite(value) || Double.isNaN(value)) {
            return 0;
        }
        BigDecimal bNumber = new BigDecimal(value);
        return bNumber.setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 小数取精度，四舍五入
     * @return
     */
    public static float getScale(float value, int scale) {
        if(Double.isInfinite(value) || Double.isNaN(value)) {
            return 0;
        }
        BigDecimal bNumber = new BigDecimal(value);
        return bNumber.setScale(scale, BigDecimal.ROUND_HALF_UP).floatValue();
    }

    public static int getScale(int denominator,int numerator) {
        if(numerator==0) {
            return denominator;
        }
        BigDecimal bNumber = new BigDecimal((double)denominator/numerator);
        return bNumber.setScale(0, BigDecimal.ROUND_HALF_UP).intValue();
    }
    public static long getScale(long denominator,long numerator) {
        BigDecimal bNumber = new BigDecimal((double)denominator/numerator);
        return bNumber.setScale(0, BigDecimal.ROUND_HALF_UP).intValue();
    }

    public static void main(String[] args) {
        double value = -1.0/0.0;
        System.out.println(FormatUtil.getScale(value,3));
    }
}
