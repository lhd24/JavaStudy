package com.study.baseapi;

import java.util.Random;

/**
 * Created by root on 2019/8/22.
 */
public class DemoRandom {
    public static void main(String[] args) {
        Random r = new Random();

        //是int的所有范围，带Int正负值
        int num1 = r.nextInt();
        System.out.println("随机数：" + num1);

        //左闭右开，范围是0，1，2
        int num2 = r.nextInt(3);

        //100.fori
//        for (int i = 0; i < 100; i++) {
//
//        }
    }
}
