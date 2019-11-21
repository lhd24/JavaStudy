package com.jdbctemplate;

import com.domain.User;
import com.utils.JDBCDruidUtils;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class JdbcTempleTest {
    //Junit单元测试，可以让方法独立执行

    //1. 获取JDBCTemplate对象
    private JdbcTemplate template = new JdbcTemplate(JDBCDruidUtils.getDataSource());

    @Test
    public void test1(){
        //2. 定义sql
        String sql = "update users set surname = '测试2' where id = 20";
        //3. 执行sql
        int count = template.update(sql);
        System.out.println(count);
    }

    @Test
    public void test2(){
        String sql = "insert into users(id,ename,dept_id) values(?,?,?)";
        int count = template.update(sql, 1015, "郭靖", 10);
        System.out.println(count);
    }

    @Test
    public void test3(){
        String sql = "delete from users where id = ?";
        int count = template.update(sql, 22);
        System.out.println(count);
    }

    /**
     * 4.查询id为1001的记录，将其封装为Map集合
     * 字段名为key，字段值为value。封装成一个Map集合。所以长度只能唯一
     * 注意：这个方法查询的结果集长度只能是1
     */
    @Test
    public void test4(){
        String sql = "select * from users where id = ? or id = ?";
        Map<String, Object> map = template.queryForMap(sql, 20,22);
        System.out.println(map);
        //{id=1001, ename=孙悟空, job_id=4, mgr=1004, joindate=2000-12-17, salary=10000.00, bonus=null, dept_id=20}
    }

    /**
     * 5. 查询所有记录，将其封装为List
     * 注意：将每一条记录封装为一个Map集合，再将Map集合装载到List集合中
     */
    @Test
    public void test5(){
        String sql = "select * from users";
        List<Map<String, Object>> list = template.queryForList(sql);

        for (Map<String, Object> stringObjectMap : list) {
            System.out.println(stringObjectMap);
        }
    }

    /**
     * 6. 查询所有记录，将其封装为Users对象的List集合
     * query():查询结果，将结果封装为JavaBean对象
     *  query的参数：RowMapper
     *      一般我们使用BeanPropertyRowMapper实现类。可以完成数据到JavaBean的自动封装
     *      new BeanPropertyRowMapper<类型>(类型.class)
     */
    @Test
    public void test6(){
        String sql = "select * from users";
        List<User> list = template.query(sql, new RowMapper<User>() {

            @Override
            public User mapRow(ResultSet rs, int i) throws SQLException {
                User user = new User();
                int id = rs.getInt("id");
                String surname = rs.getString("surname");
                String username = rs.getString("username");
                Date lastLoginTime = rs.getDate("lastLoginTime");

                user.setId(id);
                user.setSurname(surname);
                user.setUsername(username);
                user.setLastLoginTime(lastLoginTime);

                return user;
            }
        });

        for (User user : list) {
            System.out.println(user);
        }
    }

    /**
     * 6. 查询所有记录，将其封装为Emp对象的List集合
     * 注意：使用引用类型的数据Integer，Double等，可以避免null变默认值0的情况
     */
    @Test
    public void test6_2(){
        String sql = "select * from users";
        List<User> list = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
        for (User user : list) {
            System.out.println(user);
        }
    }

    /**
     * 7. 查询总记录数
     *  queryForObject：查询结果，将结果封装为对象
     *  注：此结果不能为空，否则会出异常
     *      一般用于聚合函数的查询
     */
    @Test
    public void test7(){
        String sql = "select count(id) from users";
        Long total = template.queryForObject(sql, Long.class);
        System.out.println(total);
    }

    /**
     * 7. 查询总记录数
     *  queryForObject：查询结果，将结果封装为对象
     *      查询单个对象
     */
    @Test
    public void test7_2(){
        String sql = "select * from users WHERE id = ?";
        User user = template.queryForObject(sql,
                new BeanPropertyRowMapper<User>(User.class), 19);
        System.out.println(user);
    }
}
