package com.cn.furious.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

public class LogUtils {
	public static String getStackTraces(Exception e)
	{
	    StringWriter swriter = new StringWriter();
	    PrintWriter pwriter = new PrintWriter(swriter);
	    e.printStackTrace(pwriter);
	    return swriter.toString();
	}
}
