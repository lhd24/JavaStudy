package com.study.baseapi;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by root on 2019/8/22.
 * 泛型只能是引用类型，不能是基本类型。
 * 因为ArrayList中存放的是引用类型的地址，如果希望存储基本类型必须使用对应的“包装类”
 * 基本类型     包装类(引用类型，包装类都位于java.lang包下，所以不用导包)
 * byte         Byte
 * short        Short
 * int          Integer
 * long         Long
 * float        Float
 * double       Double
 * char         Character
 * boolean      Boolean
 * 从JDK 1.5+ 开始，支持自动装箱、自动拆箱
 * 自动装箱：基本类型 --> 包装类型
 * 自动拆箱：包装类型 --> 基本类型
 *
 * 注意：
 * 数组对象，直接打印得到的是内存引用的地址
 * 对于ArrayList集合来说，直接打印得到的不是地址值，而是内容
 * 如果内容是空，得到的是空的中括号：[]
 *
 */
public class DemoArrayList {
    public static void main(String[] args) {
        // 从 JDK 1.7+ 开始，右侧的尖括号内可以不写内容，但是<>本身还是要写的。
        // ArrayList<String> strLists = new ArrayList<String>();
        ArrayList<String> strLists = new ArrayList<>();
        System.out.println(strLists);   // []
        /*
            public boolean add(E e): 向集合当中添加元素，参数的类型和泛型一致。返回值代表是否添加成功。
            备注：对于ArrayList集合来说，add添加动作一定是成功的，所以返回值可用可不用。
            但是对于其他集合(今后学习)来说，add添加动作不一定成功。

         */
        strLists.add("赵丽颖");
        System.out.println(strLists);   // [赵丽颖]

        strLists.add("迪丽热巴");
        strLists.add("古力娜扎");
        System.out.println(strLists);   // [赵丽颖,迪丽热巴,古力娜扎]

//        strLists.fori     快捷键（forr则倒序排列）
//        for (int i = 0; i < strLists.size(); i++) {
//
//        }

        Collections.sort(strLists);
    }
}
