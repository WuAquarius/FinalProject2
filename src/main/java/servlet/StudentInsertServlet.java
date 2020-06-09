package servlet;

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

/**
 * @author wunu
 * @create 2020-06-06 14:55
 * 描述:
 */
@WebServlet("/studentInsert")
public class StudentInsertServlet extends HttpServlet {
    private static final long serialVersionUID = -4392658638228508589L;

    StudentOperation studentOperation = new StudentOperation();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String major = req.getParameter("major");
        String isbn = req.getParameter("isbn");

        Student student = new Student(id,name,major,isbn);
        int i = studentOperation.insertStudent(student);


        JSONObject jsonObject = new JSONObject();
        jsonObject.put("insert",i);

        PrintWriter printWriter = resp.getWriter();
        printWriter.print(i);
        printWriter.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
