package yaebscart;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

@WebServlet(
        name = "upload",
        urlPatterns = {"/upload"})
@MultipartConfig(
        location="/Users/viber/Mamba/THE-WAY-TO-THE-FUTURE/spring-practice/yaebookshop/src/main/webapp/upload",
        fileSizeThreshold=1024*1024,
        maxFileSize=5*1024*1024,
        maxRequestSize=2*5*1024*1024)
public class FileUploadServlet30 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        Collection<Part> parts = request.getParts();

        try {
            out.write("<h2>Number of parts : " + parts.size() + "</h2>");
            for(Part part : parts) {
                printPartInfo(part, out);
                String filename = getFileName(part);
                if (filename != null) {
                    part.write(filename); // relative to location in @MultipartConfig
                }
            }
        } finally {
            out.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext()
                .getRequestDispatcher("/FileUpload.html")
                .forward(request, response);
    }

    // Print the headers for the given Part
    private void printPartInfo(Part part, PrintWriter writer) {
        StringBuilder sb = new StringBuilder();
        sb.append("<p>Name: ").append(part.getName()).append("<br>");
        sb.append("ContentType: ").append(part.getContentType()).append("<br>");
        sb.append("Size: ").append(part.getSize()).append("<br>");
        for(String header : part.getHeaderNames()) {
            sb.append(header).append(": ").append(part.getHeader(header)).append("<br>");
        }
        sb.append("</p>");
        writer.write(sb.toString());
    }

    // Gets the file name from the "content-disposition" header
    private String getFileName(Part part) {
        for (String token : part.getHeader("content-disposition").split(";")) {
            if (token.trim().startsWith("filename")) {
                return token.substring(token.indexOf('=') + 1).trim()
                        .replace("\"", "");
            }
        }
        return null;
    }
}
