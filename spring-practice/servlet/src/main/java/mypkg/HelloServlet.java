package mypkg;

import java.io.*;
import java.util.*;
import jakarta.servlet.*;             // Tomcat 10
import jakarta.servlet.http.*;        // Tomcat 10
import jakarta.servlet.annotation.*;  // Tomcat 10


public class HelloServlet extends HttpServlet {
   @Override
   public void doGet(HttpServletRequest request, HttpServletResponse response)
               throws IOException, ServletException {
      // Set the response message's MIME type
      response.setContentType("text/html;charset=UTF-8");
      // Allocate a output writer to write the response message into the network socket
      PrintWriter out = response.getWriter();
      // Write the response message, in an HTML page
      try {
         out.println("<!DOCTYPE html>");
         out.println("<html><head>");
         out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
         out.println("<title>Hello, World</title></head>");
         out.println("<body>");
         out.println("<h1>Hello, world!</h1>");  // says Hello
         // Echo client's request information
         out.println("<p>Request URI: " + request.getRequestURI() + "</p>");
         Cookie[] cookies = request.getCookies();
         if ((cookies != null) && (cookies.length > 0)) {
            out.println("cookies.cookies: " + "<br />");
            for (Cookie cookie : cookies) {
               out.println("Cookie Name: " + htmlFilter(cookie.getName()) + "<br />");
               out.println("Cookie Value: " + htmlFilter(cookie.getValue()) + "<br />");
            }
         } else {
            out.println("cookies.no-cookies: " + "<br />");
         }
         out.println("<br />");
         HttpSession session = request.getSession();

         // Display session information
         out.println("sessions.id:" + " " + session.getId() + "<br />");
         out.println("sessions.created:" + " ");
         out.println(new Date(session.getCreationTime()) + "<br />");
         out.println("sessions.lastaccessed:" + " ");
         out.println(new Date(session.getLastAccessedTime()) + "<br /><br />");
         //
         out.println("<p>Protocol: " + request.getProtocol() + "</p>");
         out.println("<p>PathInfo: " + request.getPathInfo() + "</p>");
         out.println("<p>Remote Address: " + request.getRemoteAddr() + "</p>");
         // Generate a random number upon each request
         out.println("<p>A Random Number: <strong>" + Math.random() + "</strong></p>");
         out.println("</body>");
         out.println("</html>");
      } finally {
         out.close();  // Always close the output writer
      }
   }

   private static String htmlFilter(String message) {
      if (message == null) return null;
      int len = message.length();
      StringBuffer result = new StringBuffer(len + 20);
      char aChar;

      for (int i = 0; i < len; ++i) {
         aChar = message.charAt(i);
         switch (aChar) {
            case '<': result.append("&lt;"); break;
            case '>': result.append("&gt;"); break;
            case '&': result.append("&amp;"); break;
            case '"': result.append("&quot;"); break;
            default: result.append(aChar);
         }
      }
      return (result.toString());
   }

}
