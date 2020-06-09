package servlet;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import entity.Student;


import service.StudentOperation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


/**
 * @author wunu
 * @create 2020-06-06 16:17
 * 描述:
 */
@WebServlet("/studentQuery")
public class StudentQueryServlet extends HttpServlet {
    private static final long serialVersionUID = -4392658638228508589L;

    StudentOperation studentOperation = new StudentOperation();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        String key = req.getParameter("key");
        ArrayList<Student> students = studentOperation.searchStudent(key);


        JSONObject jsonObject = new JSONObject();
        jsonObject.put("students",students);
        /*JSONArray jsonArray  = new JSONArray();
        jsonArray.add(students);
        jsonObject.put("students",jsonArray);*/

        PrintWriter printWriter = resp.getWriter();
        printWriter.print(jsonObject);
        printWriter.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
