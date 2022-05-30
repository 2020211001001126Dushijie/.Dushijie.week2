package homework.controlier;

import homework.dao.OrderDao;
import homework.dao.Userdao;
import homework.modle.Order;
import homework.modle.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "AccountDetailsServlet", value = "/accountDetails")
public class AccountDetailsServlet extends HttpServlet {
    private Connection con=null;
    @Override
    public void init() throws ServletException{
        con=(Connection) getServletContext().getAttribute("con");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        javax.servlet.http.HttpSession session= (javax.servlet.http.HttpSession) request.getSession(false);
        if (session!=null&&session.getAttribute("user")!=null){
            //user has logged in
            User user=(User) session.getAttribute("user");
            int id= Integer.parseInt(user.getId());
            Userdao dao=new Userdao();
            try {
                user=dao.findById(con,id);
                request.setAttribute("user",user);
                OrderDao orderDao=new OrderDao();
                List<Order> orderList= orderDao.findByUserId(con,id);//all order for a user
                request.setAttribute("orderList",orderList);
                String path="WEB-INF/views/accountDetails.jsp";
            }catch (SQLException e){
                e.printStackTrace();
            }
        }else {
            //ask for login
            response.sendRedirect("login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
