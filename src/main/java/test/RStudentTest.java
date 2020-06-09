package test;

import dao.ReadStudent;
import entity.Student;

import java.util.List;

/**
 * @author wunu
 * @create 2020-06-06 10:11
 * 描述:
 */
public class RStudentTest {
    public static void main(String[] args) {
        List<Student> studentInfo = ReadStudent.findStudentInfo("");
        System.out.println(studentInfo.toString());
    }
}
