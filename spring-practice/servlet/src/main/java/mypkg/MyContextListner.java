package mypkg;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener()
public class MyContextListner implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>> ");
        ServletContext ctx = sce.getServletContext();
        System.out.println("==============>" + ctx.getInitParameter("jdbcDriver"));
    }
}