package cn.itcast.web.servlet.servletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 		2. 域对象：共享数据
             1. setAttribute(String name,Object value)
             2. getAttribute(String name)
             3. removeAttribute(String name)

        * ServletContext对象范围：所有用户所有请求的数据
            * 使用需谨慎，应该范围太大，贯穿Servlet服务的整个生命周期，资源也不易释放
 */
@WebServlet("/servletContextDemo3")
public class Demo3SetAttribute extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //2. 通过HttpServlet获取
        ServletContext context = this.getServletContext();

        //设置数据
        context.setAttribute("msg","haha");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
