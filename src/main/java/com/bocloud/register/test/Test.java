package com.bocloud.register.test;

/*
 * Created by EDZ on 2019/4/9.
 */

import com.bocloud.register.Util.MD5Util;

public class Test {
    @org.junit.Test
    public void test1(){
        String s = "zhuangxiangiixiang@beyondcent.com";
        System.out.println(s.length());
    }

    @org.junit.Test
    public void test() throws Exception{
        String s = "1234561111111111111";
        String s1 = MD5Util.toMd5(s);
        String s2 = MD5Util.convertMD5(s);
        System.out.println("未加密："+s);
        System.out.println("md5后："+s1+",长度是： "+s1.length());
        System.out.println("加密："+s2);
        System.out.println("解密后："+MD5Util.convertMD5(s2));
    }

}
