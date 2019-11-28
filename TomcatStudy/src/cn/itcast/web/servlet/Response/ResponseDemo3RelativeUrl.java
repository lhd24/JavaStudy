package cn.itcast.web.servlet.Response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 1. 路径分类
     1. 相对路径：通过相对路径不可以确定唯一资源
         * 如：./index.html
         * 不以/开头，以.开头路径

         * 规则：找到当前资源和目标资源之间的相对位置关系
             * ./：当前目录
             * ../:后退一级目录
     2. 绝对路径：通过绝对路径可以确定唯一资源
         * 如：http://localhost/day15/responseDemo2		/day15/responseDemo2
         * 以/开头的路径

         * 规则：判断定义的路径是给谁用的？判断请求将来从哪儿发出
             * 给客户端浏览器使用：需要加虚拟目录(项目的访问路径)
                 * 建议虚拟目录动态获取：request.getContextPath()
                 * <a> , <form> 重定向...
             * 给服务器使用：不需要加虚拟目录
                * 转发路径
 *
 */
@WebServlet("/responseDemo3")
public class ResponseDemo3RelativeUrl extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //重定向是从客户机发出的请求，所以需要加上虚拟目录见Demo1
        //转发的时候不需要写虚拟目录
        request.getRequestDispatcher("/responseDemo2").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
