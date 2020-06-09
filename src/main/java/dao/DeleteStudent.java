package dao;

import util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @author wunu
 * @create 2020-06-06 10:15
 * 描述:删除学生记录
 */
public class DeleteStudent {
    public static int deleteStudentInfo(String id,String isbn){
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "delete from students where id = ? and isbn = ?";
            pst = conn.prepareStatement(sql);
            pst.setString(1,id);
            pst.setString(2,isbn);
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
