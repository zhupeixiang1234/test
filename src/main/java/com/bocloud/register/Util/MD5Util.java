package com.bocloud.register.Util;

import org.junit.Test;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by EDZ on 2019/4/9.
 */
public class MD5Util {

    public static String toMd5(String s) throws Exception {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("md5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] bytes = s.getBytes("utf-8");
        //System.out.println("bytes的长度:"+bytes.length);
        byte[] md5Bytes = md5.digest(bytes);
        //System.out.println("md5Bytes的长度:"+md5Bytes.length);
        StringBuffer hexValue = new StringBuffer();
        for(int i=0;i<md5Bytes.length;i++){
            int val = ((int)(md5Bytes[i]))&0xff;
            if(val<16){
                //值小于16，补0凑位
                hexValue.append("0");
            }
            //转换成16进制
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }

    /**
     * 加密解密算法 执行一次加密，两次解密
     */
    public static String convertMD5(String inStr){
        char[] a = inStr.toCharArray();
        for (int i = 0; i < a.length; i++){
            a[i] = (char) (a[i] ^ 't');
        }
        String s = new String(a);
        return s;
    }


}
