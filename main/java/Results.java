

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Results
 */
@WebServlet("/Results")
public class Results extends HttpServlet {
    

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		
		        try {
		            
		            String MailID = req.getParameter("MailID");
		            String Password = req.getParameter("Password");
					Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/result","root","Jeevanandam_28");

					String str = "SELECT Rollno,Student_Name,Sem,Mark1,Mark2,Result FROM Marklist WHERE MailID=? and Password=?;";
		            PreparedStatement ps = cn.prepareStatement(str);
		            ps.setString(1, MailID);
		            ps.setString(2, Password);
		            HttpSession hs = req.getSession();
		            hs.setAttribute("MailID", MailID );
		 
		            // Execute the query and get the result set
		            PrintWriter pw = res.getWriter();
//		            ResultSet rs = ps.executeQuery();
		            
		            // Get the PrintWriter object from HttpServletResponse
		            
		            
		            // Process each row in the result set
		            if(hs!=null) {
		            	int rollno = (int)(hs.getAttribute("Rollno"));
		            	String na = (String) (hs.getAttribute("Name"));
		                int Sem = (int)(hs.getAttribute("Sem"));
		                int Mark1 = (int)(hs.getAttribute("Mark1"));
		                int Mark2 = (int)(hs.getAttribute("Mark2"));
		                String Result = (String)(hs.getAttribute("Result"));
		                
		                // Output the result to the PrintWriter
		                pw.println("<html><body><center>");
		                pw.print("<h1>Here is your result</h1>"+"<br><hr>");
		                pw.println("<table><tr><td>Rollno</td><td>Name</td><td>Sem</td><td>Mark1</td><td>Mark2</td><td>Status</td></tr>");
		                pw.println("<tr><td>"+rollno+"</td>");
		                pw.println("<td>"+ na+"</td>");
		                pw.println("<td>"+Sem+"</td>" );
		                pw.println("<td>"+Mark1+"</td>");
		                pw.println("<td>"+Mark2+"</td>");
		                pw.println("<td>"+Result+"</td></tr>");
		                pw.println("</table></center></body></html>");

		                
		             // System.out.print(na+" " + Sem + " " + Mark1 + " " + Mark2 + " " + Mark3 + " " + Mark4 + " " + Status);
		                
		            }
		            else {
		            	pw.println("You need to login first");
		            }
		            
		            // Close the ResultSet, PreparedStatement, and Connection
		            
		        }  	catch (SQLException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
		        }
	}
}
		
