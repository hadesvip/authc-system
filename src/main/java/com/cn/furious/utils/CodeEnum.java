package com.cn.furious.utils;

/**
 * Created by zhuminghua on 16/3/8.
 */
public enum CodeEnum {
    //正常：1xxxx
    SUCCESS(10000,"请求成功"),

    //逻辑错误
    ERROR_LOGIC(20000, "逻辑错误"),

    //参数错误
    ERROR_PARAM(30000, "参数错误"),

    //系统错误
    ERROR_SYS(40000, "系统错误"),

    //未知错误
    ERROR_UNKNOWN(99999,"未知错误");

    public int code;

    public String message;

    private CodeEnum(int code, String message){
        this.code  = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static String getMessageByCode(int code) {
        CodeEnum[] enums = CodeEnum.values();
        for(int i=0; i<enums.length; i++) {
            if(code == enums[i].getCode()) {
                return enums[i].getMessage();
            }
        }
        return ERROR_UNKNOWN.getMessage();
    }
}
