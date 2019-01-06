package com.company.demo;

import java.sql.*;

public class DemoA {
    public static void dbAction() {
        try {
            Driver driver = new com.mysql.jdbc.Driver();
            DriverManager.deregisterDriver(driver);
            // 打开连接
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hello", "root", "root");
            // statement
            Statement st = con.createStatement();
            // 结果集
            String sql = "select * from users";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getInt("id"));
            }

            // 关闭结果集
            rs.close();
            // 关闭statement
            st.close();
            // 关闭连接
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
