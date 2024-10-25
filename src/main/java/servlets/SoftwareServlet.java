package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SoftwareServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String accessLevels = String.join(",", request.getParameterValues("access_levels"));

        // Use try-with-resources to ensure the Connection and PreparedStatement are closed automatically
        try (Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/UserAccessManagement", "user", "1234");
             PreparedStatement stmt = con.prepareStatement("INSERT INTO software(name, description, access_levels) VALUES (?, ?, ?)")) {
            
            // Load the PostgreSQL driver (this may be optional depending on your setup)
            Class.forName("org.postgresql.Driver");
            
            // Set the parameters for the prepared statement
            stmt.setString(1, name);
            stmt.setString(2, description);
            stmt.setString(3, accessLevels);

            // Execute the query to insert the software
            stmt.executeUpdate();

            // Redirect to the createSoftware.jsp page after successful insert
            response.sendRedirect("createSoftware.jsp");
            
        } catch (ClassNotFoundException | SQLException e) {  // Multi-catch block for specific exceptions
            // Log the error message to understand the issue and provide appropriate feedback
            e.printStackTrace();
            // Optionally, set an error message attribute and forward to an error page
            request.setAttribute("errorMessage", "An error occurred while saving the software. Please try again.");
            request.getRequestDispatcher("errorPage.jsp").forward(request, response);  // Adjust to your error handling strategy
        }
    }
}
