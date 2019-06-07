package com.renho.jdbc;

import com.renho.jdbc.connection.RenhoConnection;

import java.sql.*;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
public class RenhoDriver implements Driver {

    static {
        System.out.println("init mydriver");
        try {
            DriverManager.registerDriver(new RenhoDriver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Connection connect(String url, Properties info) throws SQLException {
        return new RenhoConnection();
    }

    @Override
    public boolean acceptsURL(String url) throws SQLException {
        return false;
    }

    @Override
    public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException {
        return new DriverPropertyInfo[0];
    }

    @Override
    public int getMajorVersion() {
        return 0;
    }

    @Override
    public int getMinorVersion() {
        return 0;
    }

    @Override
    public boolean jdbcCompliant() {
        return false;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }

}
