package dao;

import entity.Admin;
import util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @author wunu
 * @create 2020-06-07 22:41
 * 描述: 注册管理员
 */
public class Register {

    public static int insertAdminInfo(Admin admin){
        Connection conn = null;
        PreparedStatement pst = null;

        try {
            conn = JDBCUtils.getConnection();
            String sql = "insert into admins(username, password) VALUES (?,?)";
            pst = conn.prepareStatement(sql);
            pst.setString(1,admin.getUserName());
            pst.setString(2,admin.getPassword());
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
