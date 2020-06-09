package test;

import dao.Register;
import entity.Admin;

/**
 * @author wunu
 * @create 2020-06-07 23:40
 * 描述:
 */
public class RegisterTest {
    public static void main(String[] args) {
        Admin admin = new Admin("23","3255");
        int i = Register.insertAdminInfo(admin);
        System.out.println(i);
    }
}
