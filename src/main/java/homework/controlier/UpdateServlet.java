package homework.controlier;

import homework.dao.Userdao;
import homework.modle.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "UpdateServlet", value = "/UpdateServlet")
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/updateUser.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String birthday = request.getParameter("birthday");

        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setGender(gender);
        user.setBirthDate(birthday);

        Userdao userDao = new Userdao();
        javax.servlet.ServletContext application = (ServletContext) getServletContext();
        Connection conn = (Connection) application.getAttribute("conn");
        int num = 0;
        try {
            num = userDao.updateUser(conn, user);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (num != 0){
            javax.servlet.http.HttpSession session = (HttpSession) request.getSession();
            session.setAttribute("user", user);
            request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request, response);
        }else {
            request.setAttribute("message", "Update fail!");
            request.getRequestDispatcher("WEB-INF/views/updateUser.jsp").forward(request, response);
        }
    }
}
