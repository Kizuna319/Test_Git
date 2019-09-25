package service;

import dao.StudentDao;
import entity.Student;

import java.util.List;

public class StudentService {
    public boolean add(Student student) {
        StudentDao studentDao = new StudentDao();
        studentDao.add(student);
        if (student.getNumber().length() > 0)
            return true;
        else
            return false;
    }

    public List<Student> read() {
        StudentDao studentDao = new StudentDao();
        return studentDao.read();
    }

    public Student delete(Student student) {
        StudentDao studentDao = new StudentDao();
        studentDao.delete(student.getNumber());
        return student;
    }

    public Student update(Student student) {
        StudentDao studentDao = new StudentDao();
        studentDao.update(student);
        return student;
    }

    public  List<Student> readByPage(int pageNum ){
        StudentDao studentDao = new StudentDao();
        return studentDao.readByPage(pageNum);
    }
}
