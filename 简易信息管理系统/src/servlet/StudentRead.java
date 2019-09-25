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

@WebServlet("/StudentRead")
public class StudentRead extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Access-Control-All-Origin","*");
        response.setContentType("text/plain;charset=utf-8");

        StudentService studentService = new StudentService();


        String json = JSON.toJSONString(studentService.read());
        response.getWriter().println(json);
    }
}