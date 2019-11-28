package cn.itcast.test;

import cn.itcast.domain.User;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

/**
 * BeanUtils工具类，简化数据封装
    * 用于封装JavaBean的
    1. JavaBean：标准的Java类
         1. 要求：
             1. 类必须被public修饰
             2. 必须提供空参的构造器
             3. 成员变量必须使用private修饰
             4. 提供公共setter和getter方法
         2. 功能：封装数据

    2. 概念：
         成员变量：
         属性：setter和getter方法截取后的产物
            例如：getUsername() --> Username--> username

    3. 方法：
         1. setProperty()
         2. getProperty()
         3. populate(Object obj , Map map):将map集合的键值对信息，封装到对应的JavaBean对象中
 */
public class BeanUtilsTest {

    @Test
    public void test(){

        User user = new User();
        try {

            /**
             * 属性不一定完全和成员变量名一致
             *
             */

            BeanUtils.setProperty(user,"surname","male");
            System.out.println(user);

            String gender = BeanUtils.getProperty(user, "surname");
            System.out.println(gender);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
