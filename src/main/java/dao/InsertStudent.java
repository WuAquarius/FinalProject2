package dao;

import entity.Student;
import util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @author wunu
 * @create 2020-06-06 10:26
 * 描述:添加记录
 */
public class InsertStudent {
    public static int insertStudentInfo(Student s) {
        Connection conn = null;
        PreparedStatement pst = null;

        try {
            conn = JDBCUtils.getConnection();
            String sql = "insert into students(id, name, major, isbn) VALUES (?,?,?,?)";
            pst = conn.prepareStatement(sql);
            pst.setString(1,s.getId());
            pst.setString(2,s.getName());
            pst.setString(3,s.getMajor());
            pst.setString(4,s.getIsbn());
            int i = pst.executeUpdate();
            return i;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(pst, conn);
        }
        return 0;
    }
}
