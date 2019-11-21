package cn.itcast.test;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;
import org.junit.Test;

public class UserDaoTest {

    @Test
    public void testLogin(){
        User loginuser = new User();
        loginuser.setUsername("test01");
        loginuser.setPassword("AQAAAAEAACcQAAAAELW62zld8PQhO0QY2gQEoNsthtmQVCtOibRI6GYNPLHuXoVeaWH+RiKoKFLJO0Qsgg==");

        UserDao dao = new UserDao();
        User user = dao.login(loginuser);
        System.out.println(user);
    }
}
