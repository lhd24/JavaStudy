package cn.itcast.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;

/**
 * 获取请求数据
 */
@WebServlet("/demo3")
public class HttpServletRequestDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet。。。");

        // 1.获取请求行数据

        // GET /day14/demo1?name=zhangsan   HTTP/1.1
        //获取请求方式 ： GET
        String httpMethod = req.getMethod();

        //获取虚拟目录 ： /day14
        String contextPath = req.getContextPath();

        //获取Serlvet路径： /demo1
        String servletPath = req.getServletPath();

        //获取get方式请求参数：name=zhangsan
        String queryString = req.getQueryString();

        //获取请求URI: /day14/demo1
        String requestURI = req.getRequestURI();

        //获取请求URL: http://localhost/day14/demo1
        StringBuffer requestURL = req.getRequestURL();

        //获取协议及版本：HTTP/1.1
        String protocol = req.getProtocol();

        //获取客户就的IP地址
        String remoteAddr = req.getRemoteAddr();

        //2.获取请求头数据

        String header = req.getHeader("头的name");
        //获取全部
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements())
        {
            String name = headerNames.nextElement();
            //根据名称获取请求头的值(不区分大小写)
            String value = req.getHeader(name);
            System.out.println(name + "---" + value);
        }

        //3.获取请求体数据：
        //1).获取流对象
        //获取字符输入流，只能操作字符数据
        BufferedReader br = req.getReader();

        //获取字节输入流，可以操作所有类型数据(文件上传中演示)
        ServletInputStream inputStream = req.getInputStream();

        //2).再从对象中拿数据
        String line = null;
        while((line = br.readLine())!=null){
            System.out.println(line);
        }
        //BufferedReader 流不用关闭，因为是request对象中
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost。。。");
    }
}
