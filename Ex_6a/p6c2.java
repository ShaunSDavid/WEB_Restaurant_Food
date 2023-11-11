
/*Receive the cookie set already*/
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class p6c2 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setContentType("text/html");
            PrintWriter pwriter = response.getWriter();
            Cookie[] ck = request.getCookies();
            int len = ck.length;
            String value;
            pwriter.println("<h3>Hello - </h3>");
            for (int i = 0; i < len; i++) {
                value = ck[i].getValue();
                pwriter.println(value);
            }
            pwriter.print("<h2>List of Facilites</h3>");
            pwriter.print("<h4>Restaurant</h4>");
            pwriter.print("<h4>Swimming Pool</h4>");
            pwriter.print("<h4>Spa</h4>");
            pwriter.print("<h4>Gym & Park</h4>");
            pwriter.close();
        }

        catch (Exception exp) {
            System.out.println(exp);
        }
    }
}
