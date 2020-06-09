package servlet;

import com.alibaba.fastjson.JSONObject;
import service.LoginService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author wunu
 * @create 2020-06-06 12:48
 * 描述:
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = -4392658638228508589L;

    LoginService loginService = new LoginService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        JSONObject jsonObject = new JSONObject();
        /*System.out.println("username:" + username);
        System.out.println("password:" + password);*/
        if (loginService.loginCheck(username,password)){
            jsonObject.put("code",1);
        }else {
            jsonObject.put("code",0);
        }
        PrintWriter printWriter = resp.getWriter();
        printWriter.print(jsonObject);
        printWriter.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
