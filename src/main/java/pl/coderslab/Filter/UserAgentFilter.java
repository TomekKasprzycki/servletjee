package pl.coderslab.Filter;

import pl.coderslab.DAO.logDAO;
import pl.coderslab.Model.Log;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;

@WebFilter("/servlet11")
public class UserAgentFilter implements Filter {
    public void destroy() {

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        long startTime = System.currentTimeMillis();
        String userAgent = ((HttpServletRequest) req).getHeader("user-agent");
        String userName = System.getProperty("user.name");
        chain.doFilter(req, resp);
        long stopTime = System.currentTimeMillis();

        req.setAttribute("userAgent",userAgent);
        req.setAttribute("userName",userName);
        req.setAttribute("startDate",startTime);
        req.setAttribute("endDate",stopTime);

        Log log = new Log(userAgent,userName,startTime,stopTime);

//        try {
//            if (logDAO.writeApplicationLogs(log)){
//                System.out.println("Zapisano");
//            }else {
//                System.out.println("Nie zapisano");
//            }
//        }catch (SQLException e){
//            e.printStackTrace();
//        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
