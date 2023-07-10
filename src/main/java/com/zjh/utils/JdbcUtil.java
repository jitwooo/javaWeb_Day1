package com.zjh.utils;

import java.sql.*;

public class JdbcUtil {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public void connect() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javawebdb?servertimezone=UTC", "root", "yuss1063");
    }

    public void close() throws SQLException {
        preparedStatement.close();
        connection.close();
    }

    public ResultSet select(String name, String password) throws SQLException, ClassNotFoundException {
        this.preparedStatement = connection.prepareStatement("select * from t_user where name=? and password=?;");
        this.preparedStatement.setString(1, name);
        this.preparedStatement.setString(2, password);
        return preparedStatement.executeQuery();
    }


}
