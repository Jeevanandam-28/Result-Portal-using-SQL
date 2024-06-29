

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.protocol.Resultset;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String MailID = req.getParameter("MailID");
		String Password = req.getParameter("Password");
		
		boolean check = VerLogin.isvaliddata(MailID,Password,req.getSession());
		PrintWriter pw = res.getWriter();
		
		RequestDispatcher rds1 = req.getRequestDispatcher("Homepage.html");
		rds1.include(req, res);
		
		if(check)
		{
			HttpSession hs = req.getSession();
			hs.setAttribute("MailID", MailID);
			
//			RequestDispatcher rds = req.getRequestDispatcher("Dashboard");
//			rds.forward(req, res);
		}
		else {
			RequestDispatcher rd = req.getRequestDispatcher("Interface.html");
			rd.forward(req,res);
		}
	}

}



