package com.renho;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
public class Client {

    public void init() {

    }

    @Test
    public void select() throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.111.143:3306/mybatis", "root", "root123");
        PreparedStatement ps = connection.prepareStatement("INSERT INTO USER(NAME, AGE) VALUES(?, ?) ");

        connection.setAutoCommit(false);

        ps.setString(1, "renho");
        ps.setInt(2, 100);

        ps.execute();
        connection.commit();

        ps.close();
        connection.close();
    }

}
