<% if (session.getAttribute("role").equals("Manager")) { %>
    <table>
        <tr>
            <th>Employee</th>
            <th>Software</th>
            <th>Access Type</th>
            <th>Reason</th>
            <th>Action</th>
        </tr>
        <tr>
            <td>John Doe</td>
            <td>Software1</td>
            <td>Write</td>
            <td>Need for project</td>
            <td>
                <form action="ApprovalServlet" method="POST">
                    <input type="hidden" name="requestId" value="1">
                    <input type="submit" name="action" value="Approve">
                    <input type="submit" name="action" value="Reject">
                </form>
            </td>
        </tr>
    </table>
    <% } else { %>
    <p>You are not authorized to access this page.</p>
    <% } %>
    