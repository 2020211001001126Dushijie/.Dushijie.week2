package homework.controlier;

import homework.dao.ProductDao;
import homework.modle.Category;
import homework.modle.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "AddProductServlet", value = "/admin/AddProductServlet")
@MultipartConfig(maxFileSize = 16177215)
public class AddProductServlet extends HttpServlet {
    Connection con=null;
    public void init(){
        con=(Connection) getServletContext().getAttribute("con");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try{
            List<Category> categoryList=Category.findAllCategory(con);
            request.setAttribute("categoryList",categoryList);
            String path="/WEB-INF/views/admin/addProduct.jsp";
            request.getRequestDispatcher(path).forward(request,response);
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get all prameters
        String productName=request.getParameter("productName");
        double price=request.getParameter("price")!=null? Double.parseDouble(request.getParameter("price")):0.0;//if null error
        int categoryId=request.getParameter("categoryId")!=null?Integer.parseInt(request.getParameter("categoryId")):8;
        String productDescription = request.getParameter("productDescription");

        //get picture
        InputStream inputStream=null;
        Part filePart=request.getPart("picture");//baidu
        if(filePart!=null){
            System.out.println("file name:"+filePart.getName()+"size"+filePart.getSize()+"file type"+filePart.getContentType());
            inputStream=filePart.getInputStream();
        }
        //set into model
        Product product=new Product();
        product.setProductName(productName);
        product.setProductDescription(productDescription);
        product.setPicture(inputStream);
        product.setPrice(price);
        product.setCategoryId(categoryId);

        //call same in dao
        ProductDao dao=new ProductDao();
        int i=0;
        try {
            //redirect
            i=dao.save(product,inputStream,con);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (i>0)
            response.sendRedirect("productList");
    }
}
