package test;

import dao.DeleteStudent;

/**
 * @author wunu
 * @create 2020-06-06 10:22
 * 描述:
 */
public class DStudentTest {
    public static void main(String[] args) {
        int i = DeleteStudent.deleteStudentInfo("22", "22");
        System.out.println(i);
    }
}
