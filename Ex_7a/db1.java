import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class db1 extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        Connection conn = null;
        Statement stmt = null;
        PrintWriter out = response.getWriter();
        String client = request.getParameter("client");
        // String department = request.getParameter("course");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // create a database connection using jdbc , port no used here is 3306
            // database name is college and username is root , there is no password
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant", "root", "");
            stmt = conn.createStatement();
            PreparedStatement pstmt = conn.prepareStatement("insert into reservation values(?, ?, ?, ?, ?)");
            pstmt.setString(1, request.getParameter("client"));
            // Same for second parameter
            pstmt.setString(2, request.getParameter("phone"));
            pstmt.setString(3, request.getParameter("time"));
            pstmt.setString(4, request.getParameter("nop"));
            pstmt.setString(5, request.getParameter("cusine"));
            // Execute the insert command using executeUpdate()
            // to make changes in database
            pstmt.executeUpdate();
            out.println(
                    "<html><head><title>Confirmation</title><link rel='stylesheet' type='text/css' href='styles.css'></head><body>");
            out.println("<div id='head'><h1>Le Meridian</h1></div><div id='cont'>");
            out.println("<h2>Table Reserved!!! <br>");
            out.println("Thank You for choosing our restaurant!</h2>");
            out.println("<h2>Confirm your booking.</h2><br>");
            HttpSession session = request.getSession();
            session.setAttribute("client_name", client);
            out.println(
                    "<a href='http://localhost:8080/test/sample1'><button>Confirm</button></a>");
            // select data from table where dept matches the value given by user in form
            out.println("</div></body></html>");
            // Clean-up environment
            // rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.print("Do not connect to DB - Error:" + e);
        }
    }
}