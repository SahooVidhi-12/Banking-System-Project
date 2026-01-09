package com.banking;

import java.io.IOException;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/WithdrawServlet")
public class WithdrawServlet extends HttpServlet {
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
      PreparedStatement ps2 = con.prepareStatement(
        "UPDATE users SET balance = balance - ? WHERE username=? AND balance >= ?");
      ps2.setDouble(1, amount);
      ps2.setString(2, username);
      ps2.setDouble(3, amount);
      int updated = ps2.executeUpdate();
      if (updated>0) con.commit();
      else con.rollback();
    } catch (Exception e) { }
    res.sendRedirect("DashboardServlet");
  }
}
