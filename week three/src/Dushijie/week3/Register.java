package Dushijie.week3;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Register extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String email=request.getParameter("email");
        String gender=request.getParameter("gender");
        String birthDate=request.getParameter("birthDate");

        //print-write into response
        PrintWriter write=response.getWriter();
        write.println("<br>username:"+username);
        write.println("<br>password:"+password);
        write.println("<br>email:"+email);
        write.println("<br>gender:"+gender);
        write.println("<br>birthDate:"+birthDate);
        write.close();
    }
}
