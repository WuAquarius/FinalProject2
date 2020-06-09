package servlet;

import com.alibaba.fastjson.JSONObject;
import service.InviteService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author wunu
 * @create 2020-06-07 23:55
 * 描述:
 */
@WebServlet("/invite")
public class InviteServlet extends HttpServlet {
    private static final long serialVersionUID = -4392658638228508589L;
    InviteService inviteService = new InviteService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        // 接收邀请密钥
        String key = req.getParameter("key");
        JSONObject jsonObject = new JSONObject();
        if (inviteService.inviteCheck(key)){
            jsonObject.put("code",1);
        }else {
            jsonObject.put("code",0);
        }
        // 输出流
        PrintWriter writer = resp.getWriter();
        writer.print(jsonObject);
        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
