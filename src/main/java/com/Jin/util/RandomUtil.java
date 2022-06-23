package com.Jin.util;

import org.junit.Test;

import java.util.Random;

public class RandomUtil {

    private String Num;

    //生成随机数
    private String MakeNum(){
        Random random = new Random();
        String num = random.nextInt(999999) + "";
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 6-num.length(); i++) {
            sb.append("0");
        }
        num = sb.toString() + num;
        this.Num = num;
        return Num;
    }

    public String getNum(){
        return Num;
    }

    @Test
    public void test(){
        String num = MakeNum();
        System.out.println(num);
        System.out.println(num.getClass());
        Integer ig = Integer.parseInt(num);
        System.out.println(ig);
        System.out.println(ig.getClass());
    }

}
