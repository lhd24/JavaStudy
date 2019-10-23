package com.study.FileAndIO.IO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/*
    java.io.OutputStream:字节输出流
        此抽象类是表示输出字节流的所有类的超类。

    定义了一些子类共性的成员方法:
        - public void close() ：关闭此输出流并释放与此流相关联的任何系统资源。
        - public void flush() ：刷新此输出流并强制任何缓冲的输出字节被写出。
        - public void write(byte[] b)：将 b.length字节从指定的字节数组写入此输出流。
        - public void write(byte[] b, int off, int len) ：从指定的字节数组写入 len字节，从偏移量 off开始输出到此输出流。
        - public abstract void write(int b) ：将指定的字节输出流。

    java.io.FileOutputStream extends OutputStream
    FileOutputStream:文件字节输出流
    作用:把内存中的数据写入到硬盘的文件中

    构造方法:
        FileOutputStream(String name)创建一个向具有指定名称的文件中写入数据的输出文件流。
        FileOutputStream(File file) 创建一个向指定 File 对象表示的文件中写入数据的文件输出流。
        参数:写入数据的目的
            String name:目的地是一个文件的路径
            File file:目的地是一个文件
        构造方法的作用:
            1.创建一个FileOutputStream对象
            2.会根据构造方法中传递的文件/文件路径,创建一个空的文件
            3.会把FileOutputStream对象指向创建好的文件

    写入数据的原理(内存-->硬盘)
        java程序-->JVM(java虚拟机)-->OS(操作系统)-->OS调用写数据的方法-->把数据写入到文件中

    字节输出流的使用步骤(重点):
        1.创建一个FileOutputStream对象,构造方法中传递写入数据的目的地
        2.调用FileOutputStream对象中的方法write,把数据写入到文件中
        3.释放资源(流使用会占用一定的内存,使用完毕要把内存清空,提供程序的效率)
 */
public class Demo1OutputStream {
    public static void main(String[] args) throws IOException {
        //1.创建一个FileOutputStream对象,构造方法中传递写入数据的目的地
        FileOutputStream fos = new FileOutputStream("09_IOAndProperties\\a.txt");
        //2.调用FileOutputStream对象中的方法write,把数据写入到文件中
        //public abstract void write(int b) ：将指定的字节输出流。
        //在文件中显示100,写个字节
        fos.write(49);
        fos.write(48);
        fos.write(48);
        //3.释放资源(流使用会占用一定的内存,使用完毕要把内存清空,提供程序的效率)
        //fos.close();

                /*
            public void write(byte[] b)：将 b.length字节从指定的字节数组写入此输出流。
            一次写多个字节:
                如果写的第一个字节是正数(0-127),那么显示的时候会查询ASCII表
                如果写的第一个字节是负数,那第一个字节会和第二个字节,两个字节组成一个中文显示,查询系统默认码表(GBK)
         */
        byte[] bytes = {65,66,67,68,69};//ABCDE
        //byte[] bytes = {-65,-66,-67,68,69};//烤紻E
        fos.write(bytes);

        /*
            public void write(byte[] b, int off, int len) ：把字节数组的一部分写入到文件中
                int off:数组的开始索引
                int len:写几个字节
         */
        fos.write(bytes,1,2);//BC

        /*
            写入字符的方法:可以使用String类中的方法把字符串,转换为字节数组
                byte[] getBytes()  把字符串转换为字节数组
         */
        byte[] bytes2 = "你好".getBytes();
        System.out.println(Arrays.toString(bytes2));//[-28, -67, -96, -27, -91, -67]
        fos.write(bytes2);

        //释放资源
        fos.close();
    }
}