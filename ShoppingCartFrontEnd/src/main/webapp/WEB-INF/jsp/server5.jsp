
<html>
<head>
<title>server.jsp
</title>
</head>
<Body>

	<%@page import="java.sql.*" %>
	<%
		
		
		Class.forName("com.mysql.jdbc.Driver").newInstance();

		String username = "root";
		String password = "root";
		String url = "jdbc:mysql://localhost:3306/test";
		

		Connection connection = DriverManager.getConnection(url, username, password);
		Statement statement = connection.createStatement();

		ResultSet resultSet = statement.executeQuery("select * from employee");
		
		out.println("JDBC connectivity");
		while(resultSet.next())
			out.println(resultSet.getString(1)+" "+resultSet.getString(2)+" "+resultSet.getString(3));
			
	
		
	%>	
	

	
</body>
</html>
