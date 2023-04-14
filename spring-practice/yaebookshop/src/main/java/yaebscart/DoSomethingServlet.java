package yaebscart;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import myutil.InputFilter;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DoSomethingServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            out.println("<html><head><title>Do Something</title></head><body>");
            out.println("<h2>Do Somethings...</h2>");

            // Retrieve and Display the username and roles
            String userName;
            List<String> roles;
            HttpSession session = request.getSession(false);
            if (session == null) {
                out.println("<h3>You have not login!</h3>");
            } else {
                synchronized (session) {
                    userName = (String) session.getAttribute("username");
                    roles = (List<String>) session.getAttribute("roles");
                }

                out.println("<table>");
                out.println("<tr>");
                out.println("<td>Username:</td>");
                out.println("<td>" + userName + "</td></tr>");
                out.println("<tr>");
                out.println("<td>Roles:</td>");
                out.println("<td>");
                for (String role : roles) {
                    out.println(role + " ");
                }
                out.println("</td></tr>");
                out.println("<tr>");
                out.println("</table>");

                out.println("<p><a href='logout'>Logout</a></p>");
            }
            out.println("</body></html>");
        } finally {
            out.close();
        }
    }
}
