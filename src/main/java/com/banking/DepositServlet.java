package com.banking;

import java.io.IOException;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/DepositServlet")
public class DepositServlet extends HttpServlet {
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

  protected void doPost(HttpServletRequest req, HttpServletResponse res)
      throws IOException, ServletException {
    HttpSession session = req.getSession(false);
    if (session == null || session.getAttribute("username")==null) {
      res.sendRedirect("login.jsp");
      return;
    }
    String username = (String)session.getAttribute("username");
    double amount = Double.parseDouble(req.getParameter("amount"));
    try (Connection con = DBConnection.getConnection()) {
      con.setAutoCommit(false);
      PreparedStatement ps1 = con.prepareStatement(
        "UPDATE users SET balance = balance + ? WHERE username=?");
      ps1.setDouble(1, amount);
      ps1.setString(2, username);
      ps1.executeUpdate();
      con.commit();
    } catch (Exception e) { }
    res.sendRedirect("DashboardServlet");
  }
}
