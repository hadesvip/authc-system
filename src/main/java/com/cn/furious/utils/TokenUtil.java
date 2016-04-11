package com.cn.furious.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Title:
 * Description:
 * <p/>
 * Copyright：Copyright (c) 14-2-19 下午3:50
 * <p/>
 * Company：卡说
 * <p/>
 *
 * @author zhuminghua@kashuo.com
 * @version 1.0
 */
public class TokenUtil {
    private static final String TOKEN="10002000";
    private static final Map<String,String> partnerMap = new HashMap<String,String>();

    public static final String siweitongfang = "siweitongfang";
    public static final String yazuo = "yazuo";
    public static final String yolipai = "yolipai";
    public static final String oumei = "oumei";
    public static final String ouweite = "ouweite";
    static {
        partnerMap.put(siweitongfang,"swtf_t1000");
        partnerMap.put(yazuo,"yz_t1000");
        partnerMap.put(yolipai,"ylp_t1000");
        partnerMap.put(oumei,"oumei_t1000");
        partnerMap.put(ouweite,"ouweite_t1000");
    }

    /**
     * 返回唯一的TOKEN，来确认有无权限调用接口
     * @return
     */
    public static String getToken() {
        return TOKEN;
    }
    public static boolean hasTokenAuthority(String token) {
        if(StringUtils.isBlank(token)) {
            return false;
        }
        if(TOKEN.equals(token)) {
            return true;
        }
        return false;
    }
    public static boolean hasTokenAuthority(String name, String token) {
        if(TOKEN.equals(token)) {
            return true;//自己公司的token总是可以使用
        }else {
            if(partnerMap.containsKey(name)) {
                if(partnerMap.get(name).equals(token)) {
                    return true;//匹配
                }
            }
        }
        return false;
    }
    public static boolean checkPartnerToken(String token) {
        if(StringUtils.isBlank(token)) {
            return false;
        }
        if(partnerMap.containsValue(token)) {
            return true;
        }
        return false;
    }
    public static String getPartnerNameByToken(String token) {
        if(partnerMap.containsValue(token)) {
            for(Map.Entry<String,String> entry:partnerMap.entrySet()) {
                if(entry.getValue().equals(token)) {
                    return entry.getKey();
                }
            }
        }
        return null;
    }

}
