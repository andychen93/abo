package com.cl.common.util;

public class StringUtils {

	/**
	 * String 判空公共方法
	 * @param string
	 * @return
	 */
    public static boolean isNotEmpty(String string){
        if(string!=null&&!"".equals(string)){
            return true;
        }
        return false;
    }
    
}
