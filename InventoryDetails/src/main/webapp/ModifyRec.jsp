<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.DriverManager" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="Modify"  method="post">

Prodj id: <select name="Prod_id" id="Prod id">
<option>Select id</option>

<%

try {
	Class.forName("com.mysql.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/inventorydata", "root", "123456");
	Statement st = con.createStatement();
	String str = "select * from inventory_details where Prod_id=Prod_id";
	ResultSet rs = st.executeQuery(str);
	while(rs.next()){
	%>	
		<option><%=rs.getInt("Prod_id")%></option>
		<%
	}
	
	
	}catch (Exception e){
	
	}
%>
</select><br><br>

Prod name:    <input type="text" name="Prod_name" id="Prod name"><br><br> 
Prod desc:  <input type="text" name="Prod_desc" id="Prod desc"><br><br>
Prod Category:<input type="text" name="Prod_Category" id="Prod Category"><br><br>
Prod Price:     <input type="text" name="Prod_Price" id="Prod Price"><br><br>
Discount Percent:  <input type="text" name="Discount_Percent" id="Discount Percent"><br><br>
Prod Image: <div class="input-group mb-3">
  <!--  <label class="input-group-text" for="inputGroupFile01">Prod Image</label>-->
  <input type="file" name="Prod_Image"class="form-control" id="Prod Image" />
</div><br><br>


<input type="submit" value="Update">
</form> <br>



</body>
</html>