<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modify</title>
</head>
<body>
	<form method="post" action="modify?action=Update"></form>
	<input type="submit" value="Update"
	onclick="return confirm('do you want to update?')"/><br>${error}
	<table border="1">
	<tr>
	<th><input type="checkbox" id="checkBoxAll"></th>
	<th>Prod id</th>
	<th>Prod name</th>
	<th>Prod desc</th>
	<th>Prod category</th>
	<th>Prod price</th>
	<th>Discount percent</th>
	<th>Prod image</th>
	</tr>
	c:forEach var="Modify" items=${listModify }"
	<tr>
	<td><input type="checkbox" class="chkCheckBoxId" value="${modify.Prod_id }" name="Prod_id"></td>
	<td>${modify.Prod_id}</td>
	<td>${modify.Prod_name}</td>
	<td>${modify.Prod_desc}</td>
	<td>${modify.Prod_Category}</td>
	<td>${modify.Prod_Price}</td>
	<td>${modify.Prod_Percent}</td>
	<td>${modify.Prod_Image}</td>
	</tr>
	/c:forEach
	
	</table>
</body>
</html>