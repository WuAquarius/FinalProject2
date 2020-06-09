package service;

import entity.Student;

import java.util.ArrayList;

/**
 * @author wunu
 * @create 2020-06-06 11:11
 * 描述: 服务器对记录进行CRUD操作接口
 */
public interface StudentOperationImp {
    ArrayList<Student> searchStudent(String id);
    int deleteStudent(String id,String isbn);
    int insertStudent(Student s);
    int updateStudent(String id,String oisbn,String nisbn);
}
