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

public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            out.println("<html><head><title>Logout</title></head><body>");
            out.println("<h2>Logout</h2>");
            HttpSession session = request.getSession(false);
            if (session == null) {
                out.println("<h3>You have not login!</h3>");
            } else {
                session.invalidate();
                out.println("<p>Bye!</p>");
                out.println("<p><a href='index.html'>Login</a></p>");
            }
            out.println("</body></html>");
        } finally {
            out.close();
        }
    }
}
