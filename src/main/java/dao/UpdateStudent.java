package dao;

import util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @author wunu
 * @create 2020-06-06 10:45
 * 描述:更新
 */
public class UpdateStudent {
    public static int updateStudentInfo(String id,String oisbn,String nisbn){
        Connection conn = null;
        PreparedStatement pst = null;

        try {
            conn = JDBCUtils.getConnection();
            String sql = "update students set isbn = ? where id = ? and isbn = ?";
            pst = conn.prepareStatement(sql);
            pst.setString(1,nisbn);
            pst.setString(2,id);
            pst.setString(3,oisbn);
            int i = pst.executeUpdate();
            return i;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(pst,conn);
        }
        return 0;
    }
}
