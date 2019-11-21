package cn.itcast.web.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

/**
 * 其他功能
 * 1.获取请求参数通用方式（兼任get,post）
 * 2.请求转发
 *      特点
 *          1：浏览器地址不会发生变化
 *          2：只能转发到当前服务器内部资源中，不能访问外网
 *          3：只有一次请求，没有重定向
 * 3.共享数据
 *  域对象：一个有作用范围的对象，可以在范围内共享数据
 *  request域：代表一次请求的范围，一般用于请求转发的多个资源中共享数据
 *      方法：
 *          1.void setAttribute(String name,Object obj): 存储数据
 *          2.Object getAttribute(String name): 通过键获取值
 *          3.void removeAttribute(String name): 通过键移除键值对
 *
 * 4.获取ServletContext
 *      servletContext getServletContext()
 *
 * 中文乱码问题：
 *      get方式: tomcat 8 内部已经将get乱码问题解决了
 *      post方式：会乱码
 *          解决：在获取参数前，设置request的编码request.setCharacterEncoding("utf-8");
 */
@WebServlet("/demo4")
public class HttpServletRequestDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //  1.获取请求参数通用方式
        //设置流的编码，解决中文乱码
        req.setCharacterEncoding("utf-8");
        //根据参数名称获取参数值
        String username = req.getParameter("username");
        //根据参数名获取参数值的数组：hobby=xx&hobby=yy 一般用于复选框
        String[] hobbys = req.getParameterValues("hobby");
        //获取所有请求参数名称
        Enumeration<String> parameterNames = req.getParameterNames();
        //获取所有请求参数的Map集合
        Map<String, String[]> parameterMap = req.getParameterMap();

        // 2.请求转发(注意，不是302，重定向，地址栏不会变化)
        /**
         * 特点
         *          1：浏览器地址不会发生变化
         *          2：只能转发到当前服务器内部资源中，不能访问外网
         *          3：只有一次请求，没有重定向
         */
        //RequestDispatcher requestDispatcher = req.getRequestDispatcher("/demo3");
        //requestDispatcher.forward(req,resp);
        req.getRequestDispatcher("/demo3").forward(req,resp);

        /**
         *  3.共享数据
         *  域对象：一个有作用范围的对象，可以在范围内共享数据
         *  request域：代表一次请求的范围，一般用于请求转发的多个资源中共享数据
         *      方法：
         *          1.void setAttribute(String name,Object obj): 存储数据
         *          2.Object getAttribute(String name): 通过键获取值
         *          3.void removeAttribute(String name): 通过键移除键值对
         */
        req.setAttribute("msg", "hello");     //存储数据到request域中
    }
}
