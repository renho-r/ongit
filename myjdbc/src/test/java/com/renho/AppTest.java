package com.renho;

import org.junit.Test;

import java.sql.*;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://myserver:3306/beam", "root", "root123");
//        Connection connection = DriverManager.getConnection("jdbc:renho://myserver:3306/beam", "root", "root123");
        PreparedStatement ps = connection.prepareStatement("SELECT 100 FROM DUAL");
        ResultSet rs = ps.executeQuery();

        while(rs.next()) {
            System.out.println(rs.getString(1));
        }
    }
}
