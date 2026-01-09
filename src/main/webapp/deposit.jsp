<!-- deposit.jsp -->
<html>
<head>
  <title>Deposit</title>
  <link rel="stylesheet" href="css/style.css" />
</head>
<body>
  <div class="container">
    <h2>Deposit Funds</h2>
    <form action="DepositServlet" method="post">
      <input type="number" step="0.01" name="amount" placeholder="Amount" required /><br/>
      <input type="submit" value="Deposit" />
    </form>
    <a href="DashboardServlet">Back to Dashboard</a>
  </div>
</body>
</html>
