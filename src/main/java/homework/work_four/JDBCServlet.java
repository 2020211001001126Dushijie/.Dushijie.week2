package homework.work_four;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*@WebServlet(name = "JDBCServlet", urlPatterns = {"/jdbc"},
        initParams = {
                @WebInitParam(name = "driver", values = "com.microsoft.sqlserver.jdbc.SQLServerDriver"),
                @WebInitParam(name = "url", values = "jdbc.sqlserver://localhost:1433;database=keshe;encrypt=false"),
                @WebInitParam(name = "username", values = "sa"),
                @WebInitParam(name = "password", values = "admin123456")
        },
        loadOnStartup = 1
)*/
//@WebServlet(urlPatterns={"/jdbc"},loadOnstartup=1);
public class JDBCServlet extends HttpServlet {

    Connection con=null;
    @Override
    public void init() throws ServletException{
        super.init();
        //String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        //String url="jdbc.sqlserver://localhost:1433;database=keshe;encrypt=false";
        //String username="sa";
        //String password="admin123456";
        //ServletConfig config=getServletConfig();
        //String driver=config.getInitParameter("driver");
        //String url=config.getInitParameter("url");
        //String username=config.getInitParameter("username");
        //String password=config.getInitParameter("password");
        //#3-ServletContext
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
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void destroy(){
        super.destroy();
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
