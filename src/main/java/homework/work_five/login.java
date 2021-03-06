package homework.work_five;

import homework.dao.Userdao;
import homework.modle.User;
import jakarta.servlet.annotation.WebServlet;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet", value = "/login")
public class login extends HttpServlet{

        private Connection conn = null;
        private PreparedStatement ps = null;
        private ResultSet rs = null;

        @Override
        public void init() throws ServletException {
            super.init();
            conn=(Connection)getServletContext().getAttribute("con");
       /* ServletContext application = getServletConfig().getServletContext();
        String driver = application.getInitParameter("driver");
        String url = application.getInitParameter("url");
        String username = application.getInitParameter("Username");
        String password = application.getInitParameter("Password");

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }*/
        }
        @Override
        protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
            //login-request is get
            request.getRequestDispatcher("WEB-INF/Logins.jsp").forward(request,response);
        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            PrintWriter out = response.getWriter();
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            Userdao userDao=new Userdao();
            try {
               User user=userDao.findByUsernamePassword(conn,username,password);
               if(user!=null){
                   //create 3 cookies
                   Cookie usernameCookie=new Cookie("cUserName",user.getUsername());
                   Cookie passeordCookie=new Cookie("cPassword",user.getPassword());
                   Cookie rememberMeCookis=new Cookie("cRememberMe",request.getParameter("rememberMe"));
                   usernameCookie.setMaxAge(5);
                   passeordCookie.setMaxAge(5);
                   rememberMeCookis.setMaxAge(5);
                   response.addCookie(usernameCookie);
                   response.addCookie(passeordCookie);
                   response.addCookie(rememberMeCookis);

                   HttpSession session=request.getSession();
                   System.out.println("session id---"+session.getId());
                   session.setMaxInactiveInterval(10);
                   //week 8--change request to session-so we can get session in many jsp page(Logins.jsp and header.jsp)

                   //Cookie c=new Cookie("sessionid",""+user.getId());
                   //c.setMaxAge(10*60);
                   //response.addCookie(c);
                   session.setAttribute("user",user);
                   request.getRequestDispatcher("WEB-INF/views/userinfor.jsp").forward(request,response);
               }else{
                   request.setAttribute("message","Username or Password Error!!!");
                   request.getRequestDispatcher("WEB-INF/views/Logins.jsp").forward(request,response);
               }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            //response.setContentType("text/html;charset=UTF-8");


            /*String sql = "Select * from usertable where username = ? and password = ?";
            try {
                ps = conn.prepareStatement(sql);
                ps.setString(1, username);
                ps.setString(2, password);
                rs = ps.executeQuery();
                if (rs.next()){
                    // out.print("Login Success!!! <br>");    ??????
                    // out.print("Welcome,"+ username +" <br>"); ??????
                    request.setAttribute("id",rs.getInt("id"));
                    request.setAttribute("username",rs.getInt("username"));
                    request.setAttribute("password",rs.getInt("password"));
                    request.setAttribute("email",rs.getInt("email"));
                    request.setAttribute("gender",rs.getInt("gender"));
                    request.setAttribute("birthDate",rs.getInt("birthDate"));
                    request.getRequestDispatcher("userlist.jsp").forward(request,response);
                }else{
                    //  out.print("Login Error!!! <br>"); ??????
                    request.setAttribute("message","Username or Password Error!!!");
                    request.getRequestDispatcher("Logins.jsp").forward(request,response);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }*/
        }
}
