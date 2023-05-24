

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowDetails
 */
public class ShowDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("Text/jsp");
		PrintWriter out = response.getWriter();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/inventorydata", "root", "123456");
			
			PreparedStatement ps = con.prepareStatement("select * from inventory_details");
			
			out.print("<style> table, tr, th, td{ border-collapse:collapse;</style>}");
			
			out.print("<table width=75% border=1 >");
			out.print("<caption>Inventory Details: </caption><br>");
			//out.print("<tr><th>Prod id</th><th>Prod Name</th><th>Prod Desc</th><th>Prod Category</th><th>Prod Price</th><th>Discount Percent</th><th>Prod Images</th></tr>");
			
			
			ResultSet rs = ps.executeQuery();
			
			ResultSetMetaData rsmd = rs.getMetaData();
			int totalColumn = rsmd.getColumnCount();
			out.print("<tr>");
			for(int i=1; i<=totalColumn; i++) {
				out.print("<th>"+rsmd.getColumnName(i)+"</th>");
			}
			out.print("</tr>");
			while(rs.next()) {
				out.print("<tr><td>"+rs.getInt(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getString(6)+"</td><td>"+rs.getString(7)+"</td><td></tr>");
				
			}
			out.print("</table>");
			
			
			
		}catch(Exception e) {
			out.print(e);
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
