package homework.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "LoggerFilter")
public class LoggerFilter implements Filter {
    public void init(FilterConfig config) throws ServletException{

    }
    public void destroy(){

    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        //request come here -before go to servlet
        System.out.println("i am in LoggerFilter-->doFilter-before request go to servlet)");
        chain.doFilter(request,response);//go to servlet
        //call next filter if there is no next filter--go to servlet-doget or dopost
        //response come back here-after servlet
        System.out.println("i am in LoggerFilter-->doFilter()-after servlet-response");
    }
}
