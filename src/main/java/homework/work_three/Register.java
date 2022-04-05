package homework.work_three;

import jakarta.servlet.annotation.WebServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(urlPatterns = {"/register"},loadOnStartup = 1)
public class Register extends HttpServlet {

         Connection con=null;
    @Override
    public void init() throws ServletException{
        super.init();
        /*ServletContext context=getServletContext();
        String driver=context.getInitParameter("driver");
        String url=context.getInitParameter("url");
        String username=context.getInitParameter("username");
        String password=context.getInitParameter("password");

        try{
            Class.forName(driver);
            con= DriverManager.getConnection(url,username,password);
            System.out.println("init()--->"+con);
        } catch (ClassNotFoundException| SQLException e){
            e.printStackTrace();
        }*/
        con= (Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String email=request.getParameter("email");
        String gender=request.getParameter("gender");
        String birthDate=request.getParameter("birthDate");



        //print-write into response
//        PrintWriter write=response.getWriter();
//        write.println("<br>username:"+username);
//        write.println("<br>password:"+password);
//        write.println("<br>email:"+email);
//        write.println("<br>gender:"+gender);
//        write.println("<br>birthDate:"+birthDate);
//        write.close();
        String sql="insert into usertable values(?,?,?,?,?)";
        try {
            //insert data
            PreparedStatement preparedStatement=con.prepareStatement(sql);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            preparedStatement.setString(3,email);
            preparedStatement.setString(4,gender);
            preparedStatement.setString(5,birthDate);
            preparedStatement.execute();

            //get data and print data
//            PrintWriter out=response.getWriter();
//            sql="select * from usertable";
//            preparedStatement=con.prepareStatement(sql);
//            ResultSet resultSet= ((PreparedStatement) preparedStatement).executeQuery();
//            out.println("<html><body>");
//            out.println("<table border='2'>");
//            ((PrintWriter) out).println("<tr><th>ID</th><th>username</th><th>password</th><th>email</th><th>gender</th><th>birthDate</th></tr>");
//            out.println("<tr><th>"+1+"</th><th>"+username+"</th><th>"+password+"</th><th>"+email+"</th><th>"+gender+"</th><th>"+birthDate+"</th></tr>");
//            out.println("</table>");
//            out.println("</body></html>");


            //request.setAttribute("rsname",rs);
            //request.getRequestDispatcher("userlist.jsp").forward(request,response);
            //System.out.println("i am RegisterServelt-->doPost()-->forward()");
            response.sendRedirect("login.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
