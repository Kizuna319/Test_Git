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

@WebServlet("/ReadByPage")
public class ReadByPage extends HttpServlet  {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Access-Control-All-Origin","*");
        response.setContentType("text/plain;charset=utf-8");
        int pageNum = Integer.valueOf(request.getParameter("pageNum")).intValue();
        pageNum *=10;

        StudentService studentService = new StudentService();

        //System.out.println();

        String json = JSON.toJSONString(studentService.readByPage(pageNum));
        response.getWriter().println(json);
    }
}
