package com.company.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JdbcUtil {

    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "";
    private static String user = "root";
    private static String password = "root";

    static {
        try {
            Properties properties = new Properties();
            InputStream is = JdbcUtil.class.getClassLoader().getResourceAsStream("application.properties");
            properties.load(is);
            String propertyUrl = properties.getProperty("url");
            String propertyUsername = properties.getProperty("username");
            String propertyPassword = properties.getProperty("password");
            url = propertyUrl;
            user = propertyUsername;
            password = propertyPassword;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getDriver() {
        return driver;
    }

    public static void setDriver(String driver) {
        JdbcUtil.driver = driver;
    }

    public static String getUrl() {
        return url;
    }

    public static void setUrl(String url) {
        JdbcUtil.url = url;
    }

    public static String getUser() {
        return user;
    }

    public static void setUser(String user) {
        JdbcUtil.user = user;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        JdbcUtil.password = password;
    }

    public static Connection getCon() {
        Connection con = null;
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    public static void release(ResultSet rs, Statement st, Connection con) {
        closeRs(rs);
        closeSt(st);
        closeCon(con);
    }

    private static void closeRs(ResultSet rs) {
        if(rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static void closeSt(Statement st) {
        if(st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static void closeCon(Connection con) {
        if(con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
