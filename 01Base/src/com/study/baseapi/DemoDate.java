package com.study.baseapi;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * java.utils.Date: 表示日期和时间的类，精确到毫秒
 * 2018-08-08 09：55：33：333  瞬间
 *
 * 可以日期转换为毫秒进行计算，计算完毕，再把毫秒转换为日期
 * 把日期转换为毫秒：
 *      时间原点（0毫秒）：1970 年 1 月 1 日 00：00：00
 *      注意：中国要加8小时
 *
 * 把毫秒转换为日期：
 *      1 天 = 24 * 60 * 60 = 86400 秒 = 86400 * 1000 毫秒
 */
public class DemoDate {
    public static void main(String[] args) throws ParseException {
        //获取当前系统时间到原点时间经历了多少毫秒      1566892450081
        System.out.println(System.currentTimeMillis());     //可以用来计算代码执行时间

        Date date = new Date();
        System.out.println(date);       // Tue Aug 27 15:59:48 CST 2019      当前系统时间

        long time = date.getTime();     // 相当于       System.currentTimeMillis()

        date = new Date(1566892450081L);
        System.out.println(date);

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String d = df.format(date);
        System.out.println(d);      // 2019-08-27 15:54:10

        Date date1 = df.parse("2019-08-27 15:54:10");
        System.out.println(date1);
    }
}

