package com.zjh;

import org.junit.Test;

import java.sql.*;

public class Ptest{
    @Test
    public void testJdbc() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javawebdb?servertimezone=UTC", "root", "yuss1063");
        PreparedStatement preparedStatement = connection.prepareStatement("select * from t_user;");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println("id:" + resultSet.getString("id") +
                    ", name:" + resultSet.getString("name")
            + ", age:" + resultSet.getString("age"));
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }

    @Test
    public void insertJdbc() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javawebdb?servertimezone=UTC", "root", "yuss1063");

        String name = "lisi";
        int age = 20;
        PreparedStatement preparedStatement = connection.prepareStatement("insert into t_user values (null, ?, ?)");
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, String.valueOf(age));
        int i = preparedStatement.executeUpdate();
        System.out.println("i: " + i);


        preparedStatement.close();
        connection.close();
    }

}
