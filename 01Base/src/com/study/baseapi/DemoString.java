package com.study.baseapi;
/*
字符串常量池：程序当中直接写上的双引号字符串，就在字符串常量池中,new 的不在池当中。

对于基本类型来说，==是进行数值的比较。
对于引用类型来说，==时进行【地址值】的比较
 */
public class DemoString {
    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "abc";
        String str3 = new String("abc");

        char[] charArray = {'a','b','c'};
        String str4 = new String(charArray);

        System.out.println(str1 == str2);   //true
        System.out.println(str1 == str3);   //false
        System.out.println(str1 == str4);   //false
        System.out.println(str2 == str4);   //false
        System.out.println(str2 == str3);   //false
        System.out.println(str3 == str4);   //false

        //public boolean equals(Object obj):
        //参数可以是任何对象，只有参数是一个字符串并且内容相同的才会给true;否则返回false
        System.out.println(str1.equals(str3));  //true
        System.out.println(str1.equals(str4));  //true
        //public boolean equalsIgnoreCase(String str):
        //参数必须是String类型，忽略大小写，进行内容比较。

        String str5 = "ABC";
        System.out.println(str1.equals(str5));   //false
        System.out.println(str1.equalsIgnoreCase(str5));   //true

        //public String[] split(String regex):
        //按照参数的规则，将字符串切分成若干部分
        //注意事项：split方法的参数其实是一个“正则表达式”.遇到“.”，需用“\\.”
        String[] arry1 = "aaa,bbb,ccc".split(",");      //[aaa,bbb,ccc]
        arry1 = "aaa.bbb.ccc".split("\\.");             //[aaa,bbb,ccc]

    }
}
