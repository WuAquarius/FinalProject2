package test;


import service.LoginService;

/**
 * @author wunu
 * @create 2020-06-05 23:41
 * 描述:
 */
public class LoginTest {
    public static void main(String[] args) {
        LoginService loginService = new LoginService();

        boolean admin = loginService.loginCheck("admin", "123456");
        System.out.println(admin);
    }
}
