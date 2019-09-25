package dao;

import entity.Student;
import util.StudentUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    public List<Student> read() {
        String sql = "select * from student";
        List<Student> students = new ArrayList<>();

        try {
            ResultSet resultSet = select(sql);
            while (resultSet.next()) {
                Student student = new Student();
                student.setEid(resultSet.getLong("eid"));
                student.setNumber(resultSet.getString("number"));
                student.setName(resultSet.getString("name"));
                student.setAcademy(resultSet.getString("academy"));
                student.setDiscipline(resultSet.getString("discipline"));
                student.setGrade(resultSet.getString("grade"));
                student.setAge(resultSet.getString("age"));
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    public static ResultSet select(String sql) throws SQLException {
        Connection connection = StudentUtil.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        return stmt.executeQuery(sql);
    }

    public void add(Student student) {
        Connection connection = StudentUtil.getConnection();
        String sql = "insert into student (number,name,academy,discipline,grade,age) values (?,?,?,?,?,?)";

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, student.getNumber());
            preparedStatement.setString(2, student.getName());
            preparedStatement.setString(3, student.getAcademy());
            preparedStatement.setString(4, student.getDiscipline());
            preparedStatement.setString(5, student.getGrade());
            preparedStatement.setString(6, student.getAge());
            preparedStatement.executeLargeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(String number) {
        Connection connection = StudentUtil.getConnection();
        String sql = "delete from student where number = '%s'";
        sql = String.format(sql, number);
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Student student) {
        Connection connection = StudentUtil.getConnection();
        String sql = "update student set name = '%s',academy = '%s',discipline = '%s' ,grade = '%s',age='%s' where number = '%s' ";
        sql = String.format(sql, student.getName(), student.getAcademy(), student.getDiscipline(), student.getGrade(), student.getAge(), student.getNumber());
        System.out.println(sql);
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Student> readByPage(int pageNum ) {
        String sql = "select * from student limit 10 offset " + pageNum;
        List<Student> studentsOfPage = new ArrayList<>();

        try {
            ResultSet resultSet = select(sql);
            while (resultSet.next()) {
                Student student = new Student();
                student.setEid(resultSet.getLong("eid"));
                student.setNumber(resultSet.getString("number"));
                student.setName(resultSet.getString("name"));
                student.setAcademy(resultSet.getString("academy"));
                student.setDiscipline(resultSet.getString("discipline"));
                student.setGrade(resultSet.getString("grade"));
                student.setAge(resultSet.getString("age"));
                studentsOfPage.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentsOfPage;
    }
}
