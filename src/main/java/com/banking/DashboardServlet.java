package com.banking;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.*;

import jakarta.servlet.annotation.WebServlet;

@WebServlet("/DashboardServlet")
public class DashboardServlet extends HttpServlet {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

protected void doGet(HttpServletRequest req, HttpServletResponse res)
      throws IOException, ServletException {
    HttpSession session = req.getSession(false);
    if (session == null || session.getAttribute("username") == null) {
      res.sendRedirect("login.jsp");
      return;
    }
    String username = (String) session.getAttribute("username");
    double balance = 0;
    try (Connection con = DBConnection.getConnection()) {
      PreparedStatement ps = con.prepareStatement(
        "SELECT balance FROM users WHERE username=?");
      ps.setString(1, username);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) balance = rs.getDouble("balance");
    } catch (Exception e) { }
    req.setAttribute("balance", balance);
    req.getRequestDispatcher("dashboard.jsp").forward(req, res);
  }
}
