package com.cn.furious.utils;

import java.net.UnknownHostException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

@Component
public class RemotePathPrefix {

	/**
	 * ��ȡ����ķ���������·��ǰ׺"http://123.12.1.12/oa/"
	 * @throws UnknownHostException 
	 */
	public static String getPrefix(HttpServletRequest request) throws UnknownHostException{
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		return basePath;
	}
}