package com.study.baseapi;

import java.util.Objects;

public class DemoObject {

    String name;
    int age;

    //alt + INS 重写toString
    @Override
    public String toString() {
        return "DemoObject{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        String a1 = null;
        String a2 = "abc";

        //NullPointerException
//        System.out.println(a1.equals(a2));

        //false     空指针安全
        System.out.println(Objects.equals(a1,a2));
    }
}
