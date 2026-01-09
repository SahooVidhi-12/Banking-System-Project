<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>
<head>
  <title>Login</title>
  <link rel="stylesheet" href="css/style.css" />
</head>
<body>
  <div class="container">
    <h2>Login</h2>
    <form action="LoginServlet" method="post">
      <input type="text" name="username" placeholder="Username" required /><br/>
      <input type="password" name="password" placeholder="Password" required /><br/>
      <input type="submit" value="Login" />
    </form>
    <p>Don't have an account? <a href="register.jsp">Register</a></p>
  </div>
</body>
</html>
