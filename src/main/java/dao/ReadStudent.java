package dao;

import entity.Student;
import util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


/**
 * @author wunu
 * @create 2020-06-06 9:55
 * 描述:查询学生记录
 */
public class ReadStudent {
    public static ArrayList<Student> findStudentInfo(String idd) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<Student> students = new ArrayList<>();
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select * from students where id like ?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, "%" + idd + "%");
            rs = pst.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                String major = rs.getString("major");
                String isbn = rs.getString("isbn");
                Student student = new Student(id, name, major, isbn);
                students.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, pst, conn);
        }
        return students;
    }
}
