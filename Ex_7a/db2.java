import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class db2 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        Connection conn = null;
        Statement stmt = null;
        PrintWriter out = response.getWriter();
        // String client = request.getParameter("client");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // create a database connection using jdbc , port no used here is 3306
            // database name is college and username is root , there is no password
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant", "root", "");
            stmt = conn.createStatement();
            String sql;
            // select data from table where dept matches the value given by user in form

            HttpSession session = request.getSession(false);
            String n = (String) session.getAttribute("client_name");

            sql = "SELECT * FROM reservation where Client = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, n);
            ResultSet rs = pstmt.executeQuery();
            out.println(
                    "<html><head><title>Confirmation</title><link rel='stylesheet' type='text/css' href='styles.css'></head><body>");
            out.println("<div id='head'><h1>Le Meridian</h1></div><div id='cont'>");
            // Extract data from result set
            while (rs.next()) {
                // Retrieve by column name
                String name = rs.getString("Client");
                String phone = rs.getString("Phone");
                String time = rs.getString("Time");
                String people = rs.getString("People");
                String cuisine = rs.getString("Cuisine");
                // Display values
                out.println("<h2> Reservation </h2> <br>");
                out.println("<h3> Name: " + name + "<br>");
                out.println("Phone: " + phone + "<br>");
                out.println("Time: " + time + "<br>");
                out.println("Number of People: " + people + "<br>");
                out.println("Cusine: " + cuisine + "<br></h3>");
            }
            out.println("</div></body></html>");
            // Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.print("Do not connect to DB - Error:" + e);
        }
    }
}
