

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class VerLogin
 */

public class VerLogin  {
	public static boolean isvaliddata(String MailID, String Password, HttpSession hs){
		
		boolean check=false;
		
		
		try {
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/result","root","Jeevanandam_28");
			String str = "SELECT Rollno,Student_Name,Sem,Mark1,Mark2,Result FROM Marklist WHERE MailID=? and Password=?;";
			
			PreparedStatement ps;
			ps =cn.prepareStatement(str);
			ps.setString(1, MailID);
			ps.setString(2,Password);		
			ps.executeQuery();
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()) {
			check=true;
		
			int rollno = rs.getInt(1);
			String name = rs.getString(2);
			int sem = rs.getInt(3);
			int m1=rs.getInt(4);
			int m2 = rs.getInt(5);
			String result = rs.getString(6); 
			
			
			hs.setAttribute("Rollno",rollno);
			hs.setAttribute("Name",name);
			hs.setAttribute("Sem",sem);
			hs.setAttribute("Mark1",m1);
			hs.setAttribute("Mark2",m2);
			hs.setAttribute("Result",result);
			
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return check;
	}

}
