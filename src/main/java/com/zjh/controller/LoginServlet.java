package com.zjh.controller;

import com.zjh.utils.JdbcUtil;
import com.zjh.utils.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        JdbcUtil jdbcUtil = new JdbcUtil();
        try {
            jdbcUtil.connect();
            ResultSet select = jdbcUtil.select(username, password);
            if (select.next()) {
                int id = select.getInt("id");
                String name = select.getString("name");
                int age = select.getInt("age");
                User user = new User();
                user.set_information(id, name, age);
                // TODO:Session
                HttpSession session = req.getSession();
                session.setAttribute("user", user);

                RequestDispatcher requestDispatcher = req.getRequestDispatcher("success.jsp");
                requestDispatcher.forward(req, resp);
            }
            else {
                resp.sendRedirect("login.jsp");
            }

            jdbcUtil.close();

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

}
