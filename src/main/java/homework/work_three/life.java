package homework.work_three;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet("/life")

public class life extends HttpServlet {
    Connection con=null;
    public life(){
        System.out.println("i am in constryctor-->life()");
    }

    @Override
    public void init() throws ServletException{
    ServletContext context=getServletContext();
    String driver=context.getInitParameter("driver");
    String url=context.getInitParameter("url");
    String username=context.getInitParameter("username");
    String password=context.getInitParameter("password");
        try {
        Class.forName(driver);
        con= DriverManager.getConnection(url,username,password);
        System.out.println("Connection--> in JDBC"+con);
    } catch (ClassNotFoundException | SQLException e) {
        e.printStackTrace();
    }
        System.out.println("i an in init()->life"+con);
}
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("i am in init()->"+con);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    public void destory() throws SQLException {
        System.out.println("i am in destory()");
        con.close();
    }
}
