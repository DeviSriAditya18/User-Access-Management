<% if (session.getAttribute("role").equals("Employee")) { %>
    <form action="RequestServlet" method="POST">
        Software: <select name="software">
            <option value="Software1">Software1</option>
            <option value="Software2">Software2</option>
        </select><br>
        Access Type: 
        <select name="access_type">
            <option value="Read">Read</option>
            <option value="Write">Write</option>
            <option value="Admin">Admin</option>
        </select><br>
        Reason: <textarea name="reason" required></textarea><br>
        <input type="submit" value="Request Access">
    </form>
    <% } else { %>
    <p>You are not authorized to access this page.</p>
    <% } %>
    