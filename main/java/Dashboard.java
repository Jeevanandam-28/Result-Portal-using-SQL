

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Dashboard
 */
@WebServlet("/Dashboard")
public class Dashboard extends HttpServlet {


	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		PrintWriter pw =res.getWriter();
		RequestDispatcher rds = req.getRequestDispatcher("Gen.jsp");
		rds.include(req, res);
		
		HttpSession hs =req.getSession(false);
		
		if(hs!=null) {
			String name1 = (String) hs.getAttribute("Name");
			pw.println("Welcome "+name1+" to the Dashboard");
		}
		else {
			pw.println("OOPS!! Login First");
		
		}
}

}
