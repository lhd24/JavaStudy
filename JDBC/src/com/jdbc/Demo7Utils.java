package com.jdbc;

import com.domain.User;
import com.utils.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * * 定义一个方法，查询emp表的数据将其封装为对象，然后装载集合，返回。
 */
public class Demo7Utils {

    public static void main(String[] args) {
        List<User> list = new Demo7Utils().findAll();
        System.out.println(list);
        System.out.println(list.size());
    }

    /**
     * 查询所有emp对象
     * 演示JDBC工具类
     * @return
     */
    public List<User> findAll(){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<User> list = null;
        try {
           /* //1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取连接
            conn = DriverManager.getConnection("jdbc:mysql:///db3", "root", "root");*/
            conn = JDBCUtils.getConnection();
            //3.定义sql
            String sql = "select * from users";
            //4.获取执行sql的对象
            stmt = conn.createStatement();
            //5.执行sql
            rs = stmt.executeQuery(sql);
            //6.遍历结果集，封装对象，装载集合
            User emp = null;
            list = new ArrayList<User>();
            while(rs.next()){
                //获取数据
                int id = rs.getInt("id");
                String username = rs.getString("username");
                Date lastLoginTime = rs.getDate("lastLoginTime");

                // 创建emp对象,并赋值
                emp = new User();
                emp.setId(id);
                emp.setUsername(username);
                emp.setLastLoginTime(lastLoginTime);

                //装载集合
                list.add(emp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            /*if(rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }*/

            JDBCUtils.close(rs,stmt,conn);
        }
        return list;
    }

}