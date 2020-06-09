package servlet;

import com.alibaba.fastjson.JSONObject;
import service.StudentOperation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author wunu
 * @create 2020-06-06 16:58
 * 描述:
 */
@WebServlet("/studentDelete")
public class StudentDeleteServlet extends HttpServlet {
    private static final long serialVersionUID = -4392658638228508589L;

    StudentOperation studentOperation = new StudentOperation();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        String iddel = req.getParameter("iddel");
        String isbndel = req.getParameter("isbndel");
        int i = studentOperation.deleteStudent(iddel, isbndel);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",i);

        PrintWriter writer = resp.getWriter();
        writer.print(jsonObject);
        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
