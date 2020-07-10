package com.renho.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
@WebServlet(name = "hello", urlPatterns = {"/hello1", "/hello2"})
public class HelloServlet extends HttpServlet {

    public static ThreadLocal<Integer> count = new ThreadLocal<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String threadName = Thread.currentThread().getName();
        if(null == count.get()) {
            count.set(0);
            System.out.printf("Thread: %s count is null, set 0 ... \n", threadName);
        } else {
            count.set(count.get() + 1);
            System.out.printf("Thread: %s count is not null, set %d ... \n", threadName, count.get());
        }
        PrintWriter out = resp.getWriter();
        out.println("hello");
        out.flush();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        super.service(req, res);
    }
}
