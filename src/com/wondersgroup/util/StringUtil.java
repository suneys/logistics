package com.wondersgroup.util;

public class StringUtil {

    public static boolean isEmpty(String str){
        if(str==null ||str.isEmpty()||"".equals(str))
            return true;
        else
            return false;

    }

}
