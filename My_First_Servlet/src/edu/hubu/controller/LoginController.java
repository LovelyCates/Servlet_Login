package edu.hubu.controller;

import edu.hubu.jdbc.JdbcDemo;
import edu.hubu.model.Users;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginController extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("text/html;charset=utf-8");
        PrintWriter out = res.getWriter();

        String name = req.getParameter("username");
        String pwd = req.getParameter("pwd");

        name = new String(name.getBytes("8859_1"), "utf-8");
        System.out.println("name=" + name);
        System.out.println("password=" + pwd);


        List<Users> list = new JdbcDemo().findAll();
        for (Users user: list
             ) {
            String judge_name = user.getName();
            String judge_password = user.getPwd();
            if(judge_name.equals(name) && judge_password.equals(pwd)){
                req.setAttribute("name", user.getName());
                req.setAttribute("nickName", user.getNickName());
                req.getRequestDispatcher("/Main").forward(req, res);
            }
        }

        // 登录失败
        String errMsg = "用户名不存在或密码错误，请重新输入！";
        req.setAttribute("errMsg", errMsg);

        req.getRequestDispatcher("/Login").forward(req, res);


    }

    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        this.doGet(req, res);

    }

}
