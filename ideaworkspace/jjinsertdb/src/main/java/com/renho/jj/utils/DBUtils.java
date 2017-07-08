package com.renho.jj.utils;

import java.sql.*;

/**
 * Created by renho on 2017/7/7.
 */
public class DBUtils {

    public static Connection getConn() {

        String driver = PropertiesUtils.INSTANCE.getProperty("driver");
        String url = PropertiesUtils.INSTANCE.getProperty("url");
        String username = PropertiesUtils.INSTANCE.getProperty("username");;
        String password = PropertiesUtils.INSTANCE.getProperty("password");;
        Connection conn = null;
        try {
            Class.forName(driver); //classLoader,加载对应驱动
            conn = (Connection) DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void close(Connection conn, PreparedStatement ps, ResultSet rs) {

        if(null != rs) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(null != ps) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(null != conn) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
