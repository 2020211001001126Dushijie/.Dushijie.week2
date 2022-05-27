package homework.controlier;

import homework.dao.ProductDao;
import homework.modle.Category;
import homework.modle.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ShopServlet", value = "/ShopServlet")
public class ShopServlet extends HttpServlet {
    Connection con=null;

    @Override
    public void init() throws ServletException {
        super.init();
        con=(Connection) getServletContext().getAttribute("con");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Category category=new Category();
        List<Category> categoryList= null;
        try {
            categoryList = Category.findAllCategory(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("categoryList",categoryList);

        //set all product into request
        ProductDao productDao=new ProductDao();
        List<Product> productList=null;
        try {
            if(request.getParameter("categoryId")==null) {
                //show all product
                productList = productDao.findAll(con);

            }else {
                //show only one type of product
                int catId=Integer.parseInt(request.getParameter("categoryId"));
                productList=productDao.findByCategoryId(catId,con);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("productList",productList);
        String path="/WEB-INF/views/shop.jsp";
        request.getRequestDispatcher(path).forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
