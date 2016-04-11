package com.cn.furious.utils;

import java.io.File;
import java.net.URL;

/**
 * Title:
 * Description:
 * <p/>
 * Copyright：Copyright (c) 14-2-28 上午9:35
 * <p/>
 * Company：卡说
 * <p/>
 *
 * @author zhuminghua@kashuo.com
 * @version 1.0
 */
public class FilePathUtil {
    /** 没有测试
     * 取得当前类所在的文件
     * @param clazz
     * @return
     */
    public static File getClassFile(Class clazz){
        URL path = clazz.getResource(clazz.getName().substring(clazz.getName().lastIndexOf(".")+1)+".classs");
        if(path == null){
            String name = clazz.getName().replaceAll("[.]", "/");
            path = clazz.getResource("/"+name+".class");
        }
        return new File(path.getFile());
    }
    /** 没有测试
     * 得到当前类的路径
     * @param clazz
     * @return
     */
    public static String getClassFilePath(Class clazz){
        try{
            return java.net.URLDecoder.decode(getClassFile(clazz).getAbsolutePath(),"UTF-8");
        }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return "";
        }
    }

    /**
     * 取得当前类所在的ClassPath目录，比如tomcat下的classes路径
     * @param clazz
     * @return
     */
    public static File getClassPathFile(Class clazz){
        File file = getClassFile(clazz);
        for(int i=0,count = clazz.getName().split("[.]").length; i<count; i++)
            file = file.getParentFile();
        if(file.getName().toUpperCase().endsWith(".JAR!")){
            file = file.getParentFile();
        }
        return file;
    }
    /** 没有测试
     * 取得当前类所在的ClassPath路径
     * @param clazz
     * @return
     */
    public static String getClassPath(Class clazz){
        try{
            return java.net.URLDecoder.decode(getClassPathFile(clazz).getAbsolutePath(),"UTF-8");
        }catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
