<%@ page import="jakarta.servlet.http.*,jakarta.servlet.*" %>
<%
  String user = (String) session.getAttribute("username");
  if (user == null) { response.sendRedirect("login.jsp"); return; }
  Double balance = (Double) request.getAttribute("balance");
  if (balance == null) balance = 0.0;
%>
<html>
<head>
  <title>Dashboard</title>
  <link rel="stylesheet" href="css/style.css" />
</head>
<body>
  <div class="container">
    <h2>Welcome, <%= user %></h2>
    <h3>Your Balance: ₹<%= balance %></h3>
    <a href="deposit.jsp">Deposit</a> | 
    <a href="withdraw.jsp">Withdraw</a> | 
    <a href="LogoutServlet">Logout</a>
  </div>
</body>
</html>
