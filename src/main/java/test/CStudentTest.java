package test;

import dao.InsertStudent;
import entity.Student;

/**
 * @author wunu
 * @create 2020-06-06 10:44
 * 描述:
 */
public class CStudentTest {
    public static void main(String[] args) {
        Student student = new Student("4506335","33","44","55");
        int i = InsertStudent.insertStudentInfo(student);
        System.out.println(i);
    }
}
