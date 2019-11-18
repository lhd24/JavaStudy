package com.datasource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * C3P0：数据库连接池技术
     * 步骤：
         1. 导入jar包 (两个) c3p0-0.9.5.2.jar, mchange-commons-java-0.2.12.jar ，
            * 不要忘记导入数据库驱动jar包
         2. 定义配置文件：
            * 名称： c3p0.properties 或者 c3p0-config.xml
            * 路径：直接将文件放在src目录下即可。

        3. 创建核心对象 数据库连接池对象 ComboPooledDataSource
        4. 获取连接： getConnection
     * 代码：
        //1.创建数据库连接池对象
        DataSource ds  = new ComboPooledDataSource();
        //2. 获取连接对象
        Connection conn = ds.getConnection();
 */
public class Demo1C3P0 {

    public static void main(String[] args) throws SQLException {
       /* //1. 获取DataSource，使用默认配置
        DataSource ds  = new ComboPooledDataSource();

        //2.获取连接
        for (int i = 1; i <= 11 ; i++) {
            Connection conn = ds.getConnection();
            System.out.println(i+":"+conn);

            if(i == 5){
                conn.close();//归还连接到连接池中
            }
        }*/

        testNamedConfig();
    }

    public static void testNamedConfig() throws SQLException {
        // 1.1 获取DataSource，使用指定名称配置
        DataSource ds  = new ComboPooledDataSource("otherc3p0");
        //2.获取连接
        for (int i = 1; i <= 5 ; i++) {
            Connection conn = ds.getConnection();
            System.out.println(i+":"+conn);
        }
    }
}