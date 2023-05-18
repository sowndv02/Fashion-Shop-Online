/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Common;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;

/**
 *
 * @author Veetu
 */
@WebFilter(filterName = "AdminAuthorization", urlPatterns = {"/create-user", "/delete-user", "/list-user", "/update-status-user","/update-setting","/admin-dashboard","/add-setting","/setting-details","/setting-list"})
public class AdminAuthorization implements Filter {
    

    // The filter configuration object we are associated with.  If
    // this value is null, this filter instance is not currently
    // configured. 
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        HttpSession session = req.getSession();

        User user = (User) session.getAttribute("us");

        if (user != null && user.getRole_Id().equals("5")) {
            chain.doFilter(request, response);
            return;
        }
        req.setAttribute("notification", "Rất tiêc bạn không có quyền truy cập đường dẫn này!");
        request.getRequestDispatcher("index.jsp").forward(request, response);
       
        
    }

    /**
     * Return the filter configuration object for this filter.
     */

    /**
     * Set the filter configuration object for this filter.
     *
     * @param filterConfig The filter configuration object
     */

    /**
     * Destroy method for this filter
     */
    @Override
    public void destroy() {        
    }

    /**
     * Init method for this filter
     * @param filterConfig
     */
    @Override
    public void init(FilterConfig filterConfig) {        
        
    }

    /**
     * Return a String representation of this object.
     */
    
    
}

