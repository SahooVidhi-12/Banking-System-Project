package com.banking;


import java.io.IOException;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

  protected void doPost(HttpServletRequest req, HttpServletResponse res)
      throws IOException, ServletException {
    String username = req.getParameter("username");
    String password = req.getParameter("password");
    try (Connection con = DBConnection.getConnection()) {
      PreparedStatement ps = con.prepareStatement(
        "INSERT INTO users(username,password,balance) VALUES(?,?,0)");
      ps.setString(1, username);
      ps.setString(2, password);
      if (ps.executeUpdate() > 0) res.sendRedirect("login.jsp");
      else res.sendRedirect("error.jsp");
    } catch (Exception e) {
        e.printStackTrace();  // This prints to Eclipse Console!
        req.setAttribute("error", e.getMessage()); // Optional: show in JSP
        req.getRequestDispatcher("error.jsp").forward(req, res);
    }
  }
}



