package servlet;

import com.alibaba.fastjson.JSON;
import dto.MessageDto;
import entity.Student;
import service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/StudentAdd")
public class StudentAdd extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Access-Control-All-Origin","*");
        response.setContentType("text/plain;charset=utf-8");
        String number = request.getParameter("number");
        String name = request.getParameter("name");
        String academy = request.getParameter("academy");
        String discipline = request.getParameter("discipline");
        String grade = request.getParameter("grade");
        String age = request.getParameter("age");


        Student student = new Student(number,name,academy,discipline,grade,age);
        StudentService studentService = new StudentService();

        MessageDto messageDto;
        if(studentService.add(student) ){
            //设置返回值
            messageDto = new MessageDto("添加成功",true);
        }
        else {
            messageDto = new MessageDto("添加失败",false);
        }
        String json = JSON.toJSONString(messageDto);
        response.getWriter().println(json);
    }
}
