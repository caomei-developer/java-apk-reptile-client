package com.charles.util;

import java.sql.*;

public class SQLDBUtil {
    static Connection con; //声明 Connection 对象
    static PreparedStatement pStmt;//声明预处理 PreparedStatement 对象

    static String url = "jdbc:mysql://http://114.117.1.7:8888/novel";
    static String user = "root";
    static String password = "roo_novel";

    public static Connection getConnection() {//建立返回值为 Connection 的方法

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            con = DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
}
