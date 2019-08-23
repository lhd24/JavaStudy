package com.study.baseapi;

import java.util.Scanner;

/**
 * Created by root on 2019/8/22.
 */
public class DemoScanner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入数字：");
        int num = sc.nextInt();
        System.out.println("请输入字符：");
        String str = sc.next();
    }
}
