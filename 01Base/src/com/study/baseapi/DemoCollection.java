package com.study.baseapi;

import java.util.*;
import java.util.stream.Stream;

/**
 * 都为Collection 集合(对标map集合)
 *
 */
public class DemoCollection {
    public static void main(String[] args) {
        /*
            List集合
            1.有序的集合（存储和去除元素顺序相同）
            2.允许存储重复的元素
            3.有索引，可以使用普通的for循环遍历
         */

        //底层为数组
        //同步的，单线程处理，线程安全,速度慢
        Vector<String> vs = new Vector<>();

        //底层为数组，查询快，增删慢
        //不同步，异步的，多线程处理，线程不安全，速度快
        ArrayList<String> as = new ArrayList<>();

        //底层为链表，查询慢，增删快
        //不同步，多线程，线程不安全
        //里边包含了大量操作首尾元素的方法
        LinkedList<String> ls = new LinkedList<>();

        /*
            Set集合
            1.不允许存储重复元素
            2.没有索引（不能使用普通的for循环遍历）
         */

        //3.是一个无序的集合,存储元素和取出元素的顺序有可能不一致
        //4.底层是一个哈希表结构(查询的速度非常的快)（哈希表 = 数组+链表；1.8+ 数组+链表/红黑树（链表的长度超过8，变成红黑树））
        //不同步
        HashSet<String> hs = new HashSet<>();
        hs.add("asd");
        hs.add("zxc");
        for(String s : hs)
        {
            System.out.println(s);
        }


        //3.是一个无序的集合,存储元素和取出元素的顺序有可能不一致
        //此实现不是同步的
        TreeSet<String> ts = new TreeSet<>();

        //3.是一个有序的集合,存储元素和取出元素的顺序一致
        //底层是哈希表 + 链表 ： 多了一条链表（记录元素的存储顺序），保证元素有序
        //不同步
        LinkedHashSet<String> lhs = new LinkedHashSet<>();

    }
}
