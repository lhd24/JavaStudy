package cn.itcast.web.servlet.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 4. cookie的细节
     1. 一次可不可以发送多个cookie?
         * 可以
         * 可以创建多个Cookie对象，使用response调用多次addCookie方法发送cookie即可。
     2. cookie在浏览器中保存多长时间？
         1. 默认情况下，当浏览器关闭后，Cookie数据被销毁
         2. 持久化存储：
            * setMaxAge(int seconds)
                 1. 正数：将Cookie数据写到硬盘的文件中。持久化存储。并指定cookie存活时间，时间到后，cookie文件自动失效
                 2. 负数：默认值
                 3. 零：删除cookie信息
 *
 */

@WebServlet("/cookieDemo4")
public class Demo3setMaxAge extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.创建Cookie对象
        Cookie c1 = new Cookie("msg","hello");
        Cookie c2 = new Cookie("name","zhangsan");
        //2.发送多个Cookie
        response.addCookie(c1);
        response.addCookie(c2);

        //1.创建Cookie对象
        Cookie c3 = new Cookie("msg","setMaxAge");
        //2.设置cookie的存活时间
        //c3.setMaxAge(30);//将cookie持久化到硬盘，30秒后会自动删除cookie文件
        //c3.setMaxAge(-1);
        //c3.setMaxAge(300);
        c3.setMaxAge(0);//删除Cookie
        //3.发送Cookie
        response.addCookie(c3);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
