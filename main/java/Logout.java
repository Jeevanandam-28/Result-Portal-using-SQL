

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Logout
 */
@WebServlet("/Logout")
public class Logout extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		  PrintWriter pw=res.getWriter();
	      RequestDispatcher rd1=req.getRequestDispatcher("Gen.jsp");
	      rd1.include(req, res);
	      
	      HttpSession hs = req.getSession();
	      hs.getAttribute("MailID");
	      hs.invalidate();
	
		pw.print("Logged out Successfully");
	}
}
