package com.banking;
import java.io.IOException;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest req, HttpServletResponse res)
	        throws ServletException, IOException {
	    doPost(req, res);  // delegate to POST logic
	}


  protected void doPost(HttpServletRequest req, HttpServletResponse res)
      throws IOException, ServletException {
    String username = req.getParameter("username");
    String password = req.getParameter("password");
    try (Connection con = DBConnection.getConnection()) {
      PreparedStatement ps = con.prepareStatement(
        "SELECT * FROM users WHERE username=? AND password=?");
      ps.setString(1, username);
      ps.setString(2, password);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        HttpSession session = req.getSession();
        session.setAttribute("username", username);
        res.sendRedirect("DashboardServlet");
      } else {
        res.sendRedirect("login.jsp");
      }
    } catch (Exception e) {
        e.printStackTrace();  // This prints to Eclipse Console!
        req.setAttribute("error", e.getMessage()); // Optional: show in JSP
        req.getRequestDispatcher("error.jsp").forward(req, res);
    }

  }
}

