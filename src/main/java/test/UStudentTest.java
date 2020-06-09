package test;

import dao.UpdateStudent;

/**
 * @author wunu
 * @create 2020-06-06 10:55
 * 描述:
 */
public class UStudentTest {
    public static void main(String[] args) {
        int i = UpdateStudent.updateStudentInfo("22", "55", "88888");
        System.out.println(i);
    }
}
