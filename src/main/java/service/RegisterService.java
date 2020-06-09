package service;

import dao.Register;
import entity.Admin;

/**
 * @author wunu
 * @create 2020-06-07 23:43
 * 描述: 注册管理员
 */
public class RegisterService {
    public int addAdmin(Admin admin){
        return Register.insertAdminInfo(admin);
    }
}
