package servlet;

import com.alibaba.fastjson.JSONObject;
import entity.Admin;
import service.RegisterService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author wunu
 * @create 2020-06-07 23:53
 * 描述: 进行管理员注册
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = -4392658638228508589L;
    RegisterService registerService = new RegisterService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        Admin admin = new Admin(userName,password);
        int i = registerService.addAdmin(admin);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("addAdmin",i);

        PrintWriter printWriter = resp.getWriter();
        printWriter.print(i);
        printWriter.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
