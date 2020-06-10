package dao;

import util.JDBCUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/**
 * @author wunu
 * @create 2020-06-07 23:14
 * 描述:
 */
public class Invite {
    public static Boolean findInviteInfo(String id){
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtils.getConnection();
            String sql = "select * from invite where idinvite = ?";
            pst = conn.prepareStatement(sql);
            pst.setString(1,id);
            rs = pst.executeQuery();
            while (rs.next()){
                String sql2 = "delete from invite where idinvite = ?";
                pst = conn.prepareStatement(sql2);
                pst.setString(1,id);
                int i = pst.executeUpdate();
                if (i >= 1){
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,pst,conn);
        }
        return false;
    }
}
