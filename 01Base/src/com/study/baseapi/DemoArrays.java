package com.study.baseapi;

import java.util.Arrays;

/**
 * java.util.Arrays是一个与数组相关的工具类，里面提供了大量静态方法，用来实现数组常见的操作。
 *
 * public static String toString(数组)：将参数数组变成字符串(按照默认格式：[元素1，元素2，元素3...])
 * public static void sort(数组):按照默认升序(从小到大)对数组的元素进行排序。
 */
public class DemoArrays {
    public static void main(String[] args) {
        int[] intArray = {10,20,30};
        String intStr = Arrays.toString(intArray);
        System.out.println(intStr);         //[10,20,30]
    }
}
