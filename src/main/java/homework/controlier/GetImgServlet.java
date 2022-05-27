package homework.controlier;

import homework.dao.ProductDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "GetImgServlet", value = "/GetImgServlet")
public class GetImgServlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException {
        super.init();
        con=(Connection) getServletContext().getAttribute("con");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=0;
        if (request.getParameter("id")!=null)
            id=Integer.parseInt(request.getParameter("id")) ;
        ProductDao productDao=new ProductDao();

        try {
            byte[] imgByte=new byte[0];
            imgByte = productDao.getPictureById(id,con);
            if(imgByte!=null){
                //write into response
                response.setContentType("image/gif");//which type of data send back
                OutputStream out=response.getOutputStream();
                out.write(imgByte);
                out.flush();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
