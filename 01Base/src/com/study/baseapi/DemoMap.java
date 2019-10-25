package com.study.baseapi;

import java.util.*;

/**
 *  字典集合
 *  java.util.Map<K,V>
 *      Key:不允许重复
 */
public class DemoMap {
    public static void main(String[] args) {

        //底层是基于哈希表实现的（HashSet就是创建了一个HashMap实现的）
        //是一个无序集合
        //不同步，多线程，不安全
        //HashMap集合中(key序号是有序的,会自动排序1,2,3,4..)
        HashMap<String,String> hss = new HashMap<>();
        String a = hss.put("asd","zzz");      //如果不重复，则a是空，若重复，则返回被替代的原始值
        hss.put("zxc","z123");
        //循环遍历  一
        //1.获取Set集合
        //2.通过遍历Set集合的key，获得Map集合每个元素
        Set<String> strings = hss.keySet();
        for (String s : strings)
        {
            String s1 = hss.get(s);
            System.out.println(s + "=" +s1);
        }

        System.out.println(".......................");

        //循环遍历  二
        //1.通过entrySet获取多个Entry集合对象
        //2.遍历Set集合，获取每一个Entry对象
        //3.通过getKey()和getValue()获取键值对
        Set<Map.Entry<String, String>> entrySet = hss.entrySet();
        for (Map.Entry<String, String> entry : entrySet)
        {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + "=" + value);
        }

        //哈希表 + 链表 （原理同LinkedHashSet）
        //有序
        //不同步
        LinkedHashMap<String,String> lhss = new LinkedHashMap<>();

        //底层是一个哈希表
        //同步的，单线程
        //不能存null值或键，之前所有集合都可以
        Hashtable<String,String> htss = new Hashtable<>();
    }
}
