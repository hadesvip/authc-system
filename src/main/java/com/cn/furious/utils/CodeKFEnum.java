package com.cn.furious.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by zhuminghua on 16/3/8.
 */
public enum CodeKFEnum {

    SUCCESS("SUCCESS","操作成功"),
    TERMINAL_NOT_EXIST("TERMINAL_NOT_EXIST","终端不存在"),
    TERMINAL_BEEN_DISABLED("TERMINAL_BEEN_DISABLED","终端已被禁用"),
    SHOP_NOT_EXIST("SHOP_NOT_EXIST","商户不存在"),
    SHOP_BEEN_DISABLED("SHOP_BEEN_DISABLED","商户已被禁用"),
    ATURE_ERROR("SIGNATURE_ERROR","签名错误"),
    UNSUPPORT_OPERATION("UNSUPPORT_OPERATION","不支持的操作"),
    UNKNOW_ERROR("UNKNOW_ERROR","系统繁忙"),
    MISSING_METHOD("MISSING_METHOD","缺少方法名参数"),
    MISSING_SIGNATURE("MISSING_SIGNATURE","缺少签名参数"),
    BUSINESS_ERROR("BUSINESS_ERROR","业务层错误"),
    SYSTEM_ERROR("SYSTEM_ERROR","系统错误");

    public String code;

    public String message;

    private CodeKFEnum(String code, String message){
        this.code  = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static String getMessageByCode(String code) {
        CodeKFEnum[] enums = CodeKFEnum.values();
        for(int i=0; i<enums.length; i++) {
            if(StringUtils.equalsIgnoreCase(code,enums[i].getCode())) {
                return enums[i].getMessage();
            }
        }
        return SYSTEM_ERROR.getMessage();
    }
}
