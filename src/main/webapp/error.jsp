<%@ page isErrorPage="true" %>
<h2>An error occurred. Please try again.</h2>
<% if (request.getAttribute("error") != null) { %>
    <p style="color:red;"><%= request.getAttribute("error") %></p>
<% } %>
<a href="index.jsp">Home</a>
