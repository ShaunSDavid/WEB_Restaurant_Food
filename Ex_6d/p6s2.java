import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class p6s2 extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            HttpSession session = request.getSession(false);
            String n = (String) session.getAttribute("login_name");
            out.print("Hello!! Welcome Back " + n);
            out.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
