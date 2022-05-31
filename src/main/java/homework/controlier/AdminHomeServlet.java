package homework.controlier;

import homework.modle.User;
import jakarta.servlet.annotation.WebServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "AdminHomeServlet", value = {"/admin/home", "/admin/login"})
public class AdminHomeServlet extends HomeServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session!=null && session.getAttribute("user")!=null){
            User user = (User) session.getAttribute("user");
            if ("admin".equals(user.getUsername())){
                request.getRequestDispatcher("../WEB-INF/views/admin/index.jsp").forward(request, response);
            }else {
                //have session but it's not admin user
                session.invalidate();// kill session
                request.setAttribute("message", "Unauthorized Access admin module!!!");
                request.getRequestDispatcher("../WEB-INF/views/Logins.jsp").forward(request, response);
            }
        }else {
            // don't have session or user is null
            request.setAttribute("message", "Please login as admin!!!");
            request.getRequestDispatcher("../WEB-INF/views/Logins.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
