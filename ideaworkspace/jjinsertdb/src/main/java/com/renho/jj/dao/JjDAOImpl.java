package com.renho.jj.dao;

import com.renho.jj.pojo.Jj;
import com.renho.jj.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by renho on 2017/7/7.
 */
public class JjDAOImpl {

    private static final String INSERT_SQL = "INSERT INTO JJ(fundcode, name, jzrq, dwjz, gsz, gszzl, gztime) VALUES(?,?,?,?,?, ?,?)";

    public void insert(Jj jj) {
        Connection conn = DBUtils.getConn();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(INSERT_SQL);
            ps.setString(1, jj.getFundcode());
            ps.setString(2, jj.getName());
            ps.setString(3, jj.getJzrq());
            ps.setDouble(4, jj.getDwjz());
            ps.setDouble(5, jj.getGsz());
            ps.setDouble(6, jj.getGszzl());
            ps.setString(7, jj.getGztime());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(conn, ps, null);
        }
    }

}
