<% if (session.getAttribute("role").equals("Admin")) { %>
    <form action="SoftwareServlet" method="POST">
        Software Name: <input type="text" name="name" required><br>
        Description: <textarea name="description" required></textarea><br>
        Access Levels:<br>
        <input type="checkbox" name="access_levels" value="Read">Read<br>
        <input type="checkbox" name="access_levels" value="Write">Write<br>
        <input type="checkbox" name="access_levels" value="Admin">Admin<br>
        <input type="submit" value="Create Software">
    </form>
    <% } else { %>
    <p>You are not authorized to access this page.</p>
    <% } %>
    