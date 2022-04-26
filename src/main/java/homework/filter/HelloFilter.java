package homework.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
//2 way of mapping filter to servlet
//way 1-use web.xml
//way 2=use webFilter
@WebFilter(filterName = "HelloFilter",
urlPatterns = {"/hello","login","register.jsp"})
//task 1:url /hello-filter is only for one Servlet -HelloServlet
//task 2:url /*- this filter of for all servlet
//task 3:3 url -this filter for these 3 url only
public class HelloFilter implements Filter {
    public void init(FilterConfig config) throws ServletException{
        System.out.println("i am in HelloFilter-->init()");//when called?
    }
    public void destroy(){
        System.out.println("i am in HelloFilter-->destroy");//when called
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain) throws ServletException, IOException {
        //request come here -before go to servlet -doGet() or doPost()
        System.out.println("i am in HelloFilter-->doFilter-before servlet-(request come here)");
        chain.doFilter(request,response);//go to servlet
        //call next filter-if there no next filter -then go to servlet
        //response come back here -after servlet
        System.out.println("i am in HelloFilter-->doFilter()-after servlet-(response come here)");
    }
}
