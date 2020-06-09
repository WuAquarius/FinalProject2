package test;


import util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author wunu
 * @create 2020-06-05 20:38
 * 描述:
 */
public class JdbcTest {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "insert into admins(id, username, password) VALUES (?,?,?)";
            pst = conn.prepareStatement(sql);
            pst.setInt(1,9);
            pst.setString(2,"lisi");
            pst.setString(3,"3333");
            int i = pst.executeUpdate();
            System.out.println(i);
        } catch (Exception throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(pst,conn);
        }
    }
}
