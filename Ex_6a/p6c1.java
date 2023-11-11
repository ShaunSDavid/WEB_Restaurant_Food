
/*Username is set as cookies and redirected to next page*/
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class p6c1 extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setContentType("text/html");
            PrintWriter pwriter = response.getWriter();
            String in_uname = request.getParameter("uname");
            Cookie c = new Cookie("UserCookie", in_uname);
            response.addCookie(c);
            pwriter.print("<h3>Welcome to Le Meriden</h3>" + in_uname);
            pwriter.println("<br /> Click here to know your status");
            pwriter.print("<br /> <a href='cookieC2'>Facilities</a>");
            pwriter.close();
        } catch (Exception exp) {
            System.out.println(exp);
        }
    }
}
