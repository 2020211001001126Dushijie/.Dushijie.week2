package homework.work_six;

import jakarta.servlet.annotation.WebServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/search")
public class SearchServlet extends javax.servlet.http.HttpServlet {
    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {
        String txt = request.getParameter("txt");
        String search = request.getParameter("search");

        if (txt == null){
            response.sendRedirect(request.getContextPath() + "/week2/index.jsp");
        }else {
            if ("baidu".equals(search)){
                response.sendRedirect("https://www.baidu.com/s?wd=" + txt);
            }else if ("bing".equals(search)){
                response.sendRedirect("https://cn.bing.com/search?q=" + txt);
            }else if ("google".equals(search)){
                response.sendRedirect("https://www.google.com/search?q=" + txt);
            }
        }
    } @Override
    protected void doPost(javax.servlet.http.HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
