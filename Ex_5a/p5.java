import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class p5 extends HttpServlet {
    private String message;

    public void init() throws ServletException {
        message = "Welcome Back";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h1>" + message + "</h1>");
        out.println("<p> This is Parotta </p>");
        out.println(
                "<p style = \"font-family: Verdana, Geneva, Tahoma, sans-serif;\">A layered flatbread from southern India, made with ghee or oil and usually maida or white flour. paratha..</p>");
    }

    public void destroy() {
        // do nothing.
    }
}
