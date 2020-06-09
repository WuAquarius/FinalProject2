package service;

import dao.InsertStudent;
import dao.DeleteStudent;
import dao.ReadStudent;
import dao.UpdateStudent;
import entity.Student;

import java.util.ArrayList;

/**
 * @author wunu
 * @create 2020-06-06 11:34
 * 描述:
 */
public class StudentOperation implements StudentOperationImp{
    @Override
    public ArrayList<Student> searchStudent(String id) {
        return ReadStudent.findStudentInfo(id);
    }

    @Override
    public int deleteStudent(String id, String isbn) {
        return DeleteStudent.deleteStudentInfo(id,isbn);
    }

    @Override
    public int insertStudent(Student s) {
        return InsertStudent.insertStudentInfo(s);
    }

    @Override
    public int updateStudent(String id, String oisbn, String nisbn) {
        return UpdateStudent.updateStudentInfo(id, oisbn, nisbn);
    }
}
