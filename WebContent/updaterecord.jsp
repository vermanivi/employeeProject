<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome to Update Form</h1> 
<form action="Update_record" method ="post">
		<table style="with 50%">
			<tr>
				<td>First name</td>
				<td><input type="text" name="first_name"/></td></tr>
			<tr>
				<td>Last name</td>	
				<td><input type="text" name="last_name"/></td>
				</tr>
			<tr>
				<td>id</td>
				<td><input type="text" name="id" /></td>
				</tr>
			<tr>
				<td>age</td>
				<td><input type="number" name="age" /></td>
				</tr>
			</table>
				<input type="submit" value="Submit" />
				
</form>

</body>
</html>