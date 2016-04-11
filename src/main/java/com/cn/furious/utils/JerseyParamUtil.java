package com.cn.furious.utils;

import java.util.List;

import javax.ws.rs.core.MultivaluedMap;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

/**
 * Title:
 * Description:
 * <p/>
 * Copyright：Copyright (c) 14-2-19 下午3:36
 * <p/>
 * Company：卡说
 * <p/>
 *
 * @author zhuminghua@kashuo.com
 * @version 1.0
 */
public class JerseyParamUtil {
    /**
     * 取得MultivaluedMap中key-value的第一个值，作为String返回
     * @param formParams
     * @param key
     * @return
     */
    public static String getParam(MultivaluedMap<String, String> formParams, String key) {
        if(formParams == null ) {
            return null;
        }
        if(StringUtils.isBlank(key)) {
            return null;
        }
        if(formParams.containsKey(key)) {
            List<String> list = formParams.get(key);
            if(CollectionUtils.isEmpty(list)) {
                return null;
            }
            return list.get(0);
        } else {
            return null;
        }
    }
}
