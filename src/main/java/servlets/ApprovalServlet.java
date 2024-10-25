package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ApprovalServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String requestId = request.getParameter("requestId");
        String action = request.getParameter("action");

        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/UserAccessManagement", "user", "1234");

            String query = "UPDATE requests SET status = ? WHERE id = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, action);
            stmt.setString(2, requestId);

            stmt.executeUpdate();
            response.sendRedirect("pendingRequests.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
