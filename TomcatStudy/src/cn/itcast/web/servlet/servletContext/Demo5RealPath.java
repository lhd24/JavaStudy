package cn.itcast.web.servlet.servletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * 3. 获取文件的真实(服务器)路径
     1. 方法：String getRealPath(String path)
         String b = context.getRealPath("/b.txt");//web目录下资源访问
         System.out.println(b);

         String c = context.getRealPath("/WEB-INF/c.txt");//WEB-INF目录下的资源访问
         System.out.println(c);

         String a = context.getRealPath("/WEB-INF/classes/a.txt");//src目录下的资源访问
         System.out.println(a);
 */
@WebServlet("/servletContextDemo5")
public class Demo5RealPath extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 通过HttpServlet获取
        ServletContext context = this.getServletContext();

        // 获取文件的服务器路径
        String b = context.getRealPath("/b.txt");//web目录下资源访问
        System.out.println(b);
        // File file = new File(realPath);

        String c = context.getRealPath("/WEB-INF/c.txt");//WEB-INF目录下的资源访问
        System.out.println(c);

        String a = context.getRealPath("/WEB-INF/classes/a.txt");//src目录下的资源访问
        //JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties")
        //只能获取 src 目录下，有局限
        System.out.println(a);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
