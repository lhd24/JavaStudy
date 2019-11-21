package cn.itcast.web.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * Servlet相关配置
     1. urlpartten:Servlet访问路径
         1. 一个Servlet可以定义多个访问路径 ： @WebServlet({"/d4","/dd4","/ddd4"})
         2. 路径定义规则：
             1. /xxx：路径匹配
             2. /xxx/xxx:多层路径，目录结构
             3. *.do：扩展名匹配
 */
//@WebServlet(urlPatterns = "/demo2")
@WebServlet("/demo2")
public class ServletDemo2 implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Servlet 3.0 来了。。。");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
