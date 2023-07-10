package com.zjh.controller;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;


@WebServlet("/hellojavaweb")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
//        req.setCharacterEncoding("utf-8");
//        String name = req.getParameter("name");
//        String age = req.getParameter("age");
//        System.out.println("name:"+name);
//        System.out.println("age:"+age);
//
//        resp.getWriter().write("Hello");


//        req.setCharacterEncoding("utf-8");
//        Map<String, String[]> parameterMap = req.getParameterMap();
//        Set<Map.Entry<String, String[]>> entrySet = parameterMap.entrySet();
//        for(Map.Entry<String, String[]> entry: entrySet) {
//            System.out.println(entry.getKey() + ":" + Arrays.toString(entry.getValue()));
//        }
//        resp.setContentType("text/html;charset=utf-8");
//        resp.getWriter().write("received.");


        req.setCharacterEncoding("utf-8");
        Map<String, String[]> parameterMap = req.getParameterMap();
        Set<Map.Entry<String, String[]>> entrySet = parameterMap.entrySet();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javawebdb?servertimezone=UTC", "root", "yuss1063");
            PreparedStatement preparedStatement = connection.prepareStatement("insert into t_user values (null, ?, ?, ?)");
            int index = 1;
            for(Map.Entry<String, String[]> entry: entrySet) {
//                System.out.println(entry.getKey() + ":" + Arrays.toString(entry.getValue()));
                String key_value = entry.getValue()[0];
                preparedStatement.setString(index, key_value);
                index++;
            }
            preparedStatement.setString(index, "123");
            int i = preparedStatement.executeUpdate();
            System.out.println("i: " + i);

            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().write("received.");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        doGet(req, resp);
    }
}
