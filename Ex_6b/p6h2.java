import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class p6h2 extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            // Getting the value from the hidden field
            String n = request.getParameter("uname");
            out.print("Hello " + n + ". Good to be back.");
            out.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
