

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Modify
 */
public class Modify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Modify() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("Text/jsp");
		PrintWriter out = response.getWriter();
		
		int Prod_id=Integer.parseInt(request.getParameter("Prod_id"));
		String Prod_name=request.getParameter("Prod_name");
		String Prod_desc=request.getParameter("Prod_desc");
		String Prod_Category=request.getParameter("Prod_Category");
		String Prod_Price=request.getParameter("Prod_Price");
		String Discount_Percent=request.getParameter("Discount_Percent");
		String Prod_Image=request.getParameter("Prod_Image");
		
		
		
		int status=0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/inventorydata", "root", "123456"); 
			
			PreparedStatement ps = con.prepareStatement("update inventory_details set Prod_name=?, Prod_desc=?, Prod_Category=?, Prod_Price=?, Discount_Percent=?, Prod_Image=? where Prod_id=?");
			ps.setString(1, Prod_name);
			ps.setString(2, Prod_desc);
			ps.setString(3, Prod_Category);
			ps.setString(4, Prod_Price);
			ps.setString(5, Discount_Percent);
			ps.setString(6, Prod_Image);
			ps.setInt(7, Prod_id);
			status = ps.executeUpdate();
			
			if(status>0) {
				out.print("<p>Record Modified Successfully:</p>");
				
				request.getRequestDispatcher("index.jsp").include(request, response);
			}else {
				out.print("<p>Sorry! unable to save Records</p>");
				
				request.getRequestDispatcher("UpdateRecord.jsp").include(request, response);
			}
			
		
			
			
			
			
			
	}catch(Exception e) {
		out.print(e);
	}

	}

}
