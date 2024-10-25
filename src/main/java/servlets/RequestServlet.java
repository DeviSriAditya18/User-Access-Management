package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RequestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        String software = request.getParameter("software");
        String accessType = request.getParameter("access_type");
        String reason = request.getParameter("reason");

        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/UserAccessManagement", "user", "1234");

            String query = "INSERT INTO requests(user_id, software_id, access_type, reason, status) " +
                           "VALUES ((SELECT id FROM users WHERE username = ?), " +
                           "(SELECT id FROM software WHERE name = ?), ?, ?, 'Pending')";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, software);
            stmt.setString(3, accessType);
            stmt.setString(4, reason);

            stmt.executeUpdate();
            response.sendRedirect("requestAccess.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
