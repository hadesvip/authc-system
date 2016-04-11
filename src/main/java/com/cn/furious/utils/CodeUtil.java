package com.cn.furious.utils;

import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Title:
 * Description:
 * <p/>
 * Copyright：Copyright (c) 14-2-19 上午11:46
 * <p/>
 * Company：卡说
 * <p/>
 *
 * @author zhuminghua@kashuo.com
 * @version 1.0
 */
public class CodeUtil {
    static Map<Integer, String> codeMap = new HashMap<Integer, String>();

    public final static int CODE_SUCCESS = 10000;//"请求成功"
    public final static String MESSAGE_SUCCESS = "请求成功";

    public final static int CODE_FAILURE = 99999;//未知错误
    public final static String MESSAGE_FAILURE = "未知错误";

    public final static int CODE_PARAM_ERROR = 20001;//系统错误
    public final static String MESSAGE_PARAM_ERROR = "参数错误";

    static {
        codeMap.put(CODE_SUCCESS,MESSAGE_SUCCESS);
        codeMap.put(CODE_FAILURE,MESSAGE_FAILURE);

        //参数
        codeMap.put(CODE_PARAM_ERROR,MESSAGE_PARAM_ERROR);
    }
    public static String getCodeMessage(int code) {
        String message = codeMap.get(code);
        if(message == null) {
            message = MESSAGE_FAILURE;
        }
        return message;
    }


}
