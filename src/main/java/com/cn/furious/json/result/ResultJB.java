package com.cn.furious.json.result;

import org.apache.commons.lang3.StringUtils;

import com.cn.furious.utils.CodeEnum;;

public class ResultJB {

    public int code;

    public String message;

    public String getMessage() {
        if(StringUtils.isEmpty(message)) {
            message = CodeEnum.getMessageByCode(code);
        }
        return message;
    }

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "JasonBean [code=" + code + ", message=" + message + "]";
	}
}
