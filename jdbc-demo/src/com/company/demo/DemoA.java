package com.company.demo;

import com.company.utils.JdbcUtil;

import java.sql.*;

public class DemoA {
    public static void dbAction() {
        try {
            Connection con = JdbcUtil.getCon();
            // statement
            // 结果集
            String sql = "select * from users where id=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, "1");

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getInt("id"));
            }

            JdbcUtil.release(rs, st, con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
