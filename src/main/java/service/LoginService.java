package service;

import dao.Login;

/**
 * @author wunu
 * @create 2020-06-06 13:47
 * 描述:
 */
public class LoginService {
    public boolean loginCheck(String name,String password){
        return Login.findAdmin(name,password);
    }
}
