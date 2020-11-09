package edu.hubu.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("text/html;charset=utf-8");
        PrintWriter out = res.getWriter();

        String msg = (String) req.getAttribute("errMsg");

        out.println("<!DOCTYPE HTML PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN'>");
        out.println("<html><head><title>login</title>");
        out.println("<meta http-equiv='keywords' content='keyword1,keyword2,keyword3'><meta http-equiv='description' content='this is my page'><meta http-equiv='content-type' content='text/html; charset=UTF-8'>");
        out.println("</head><body><h1>用户登录</h1>");
        out.println("<form action='/LoginController' method='post'>");
        out.println("<label for='name'>用户名：</label>");
        out.println("<input type='text' name='username' id='name' /><br />");
        out.println("<label for='pwd'>密码：</label>");
        out.println("<input type='password' name='pwd' id='pwd' /><br />");
        out.println("<input type='submit' value='登录' />");
        out.println("<input type='reset' value='重置'/>");
        out.println("</form></body></html>");
        if (msg != null) {
            out.println(msg);
        }

    }

    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        this.doGet(req, res);
    }

}
