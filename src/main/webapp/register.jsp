<html>
<head>
  <title>Register</title>
  <link rel="stylesheet" href="css/style.css" />
</head>
<body>
  <div class="container">
    <h2>Register</h2>
    <form action="RegisterServlet" method="post">
      <input type="text" name="username" placeholder="Username" required /><br/>
      <input type="password" name="password" placeholder="Password" required /><br/>
      <input type="submit" value="Register" />
    </form>
    <p>Already registered? <a href="login.jsp">Login</a></p>
  </div>
</body>
</html>
