package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * JDBC快速入门
 * 	1. 概念：Java DataBase Connectivity  Java 数据库连接， Java语言操作数据库
        JDBC本质：其实是官方（sun公司）定义的一套操作所有关系型数据库的规则，即接口。各个数据库厂商去实现这套接口，提供数据库驱动jar包。
                    我们可以使用这套接口（JDBC）编程，真正执行的代码是驱动jar包中的实现类。

         步骤：
         1. 导入驱动jar包 mysql-connector-java-5.1.37-bin.jar
         1.复制mysql-connector-java-5.1.37-bin.jar到项目的libs目录下
         2.右键-->Add As Library
         2. 注册驱动
         3. 获取数据库连接对象 Connection
         4. 定义sql
         5. 获取执行sql语句的对象 Statement
         6. 执行sql，接受返回结果
         7. 处理结果
         8. 释放资源
 */
public class Demo1Jdbc {
    public static void main(String[] args) throws Exception {

        //1. 导入驱动jar包
        //2.注册驱动        //mysql驱动5.0以后可以省略，不过还是推荐写一下
        // Class.forName("com.mysql.jdbc.Driver");

        //MySQL 8.0 以上版本的数据库连接有所不同：
            //1、MySQL 8.0 以上版本驱动包版本 mysql-connector-java-8.0.16.jar。
            //2、com.mysql.jdbc.Driver 更换为 com.mysql.cj.jdbc.Driver。
        // Class.forName("com.mysql.cj.jdbc.Driver");

        //3.获取数据库连接对象
//        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db3", "root", "root");
        /*
        		1. DriverManager：驱动管理对象
                    * 功能：
                        1. 注册驱动：告诉程序该使用哪一个数据库驱动jar
                            static void registerDriver(Driver driver) :注册与给定的驱动程序 DriverManager 。
                            写代码使用：  Class.forName("com.mysql.jdbc.Driver");
                            通过查看源码发现：在com.mysql.jdbc.Driver类中存在静态代码块
                             static {
                                    try {
                                        java.sql.DriverManager.registerDriver(new Driver());
                                    } catch (SQLException E) {
                                        throw new RuntimeException("Can't register driver!");
                                    }
                                }

					注意：mysql5之后的驱动jar包可以省略注册驱动的步骤。
				2. 获取数据库连接：
					* 方法：static Connection getConnection(String url, String user, String password)
					* 参数：
						* url：指定连接的路径
							* 语法：jdbc:mysql://ip地址(域名):端口号/数据库名称
							* 例子：jdbc:mysql://localhost:3306/db3
							* 细节：如果连接的是本机mysql服务器，并且mysql服务默认端口是3306，则url可以简写为：jdbc:mysql:///数据库名称
						* user：用户名
						* password：密码
         */
        Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.146.156:3306/Cms_Dev?serverTimezone=UTC", "cmsdev", "qwe123");
        /*
            2. Connection：数据库连接对象
			1. 功能：
				1. 获取执行sql 的对象
					* Statement createStatement()
					* PreparedStatement prepareStatement(String sql)
				2. 管理事务：
					* 开启事务：setAutoCommit(boolean autoCommit) ：调用该方法设置参数为false，即开启事务
					* 提交事务：commit()
					* 回滚事务：rollback()
         */

        //4.定义sql语句
//        String sql = "update account set balance = 2000 where id = 1";
        String sql = "update users set surname = '测试' WHERE id = 20";
        //5.获取执行sql的对象 Statement
        Statement stmt = conn.createStatement();
        /*
            3. Statement：执行sql的对象
                1. 执行sql
                    1. boolean execute(String sql) ：可以执行任意的sql 了解
                    2. int executeUpdate(String sql) ：执行DML（insert、update、delete）语句、DDL(create，alter、drop)语句
                        * 返回值：影响的行数，可以通过这个影响的行数判断DML语句是否执行成功 返回值>0的则执行成功，反之，则失败。
                    3. ResultSet executeQuery(String sql)  ：执行DQL（select)语句
         */

        //6.执行sql
        int count = stmt.executeUpdate(sql);
        //7.处理结果
        System.out.println(count);
        //8.释放资源
        stmt.close();
        conn.close();

    }
}
