<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:useBean id="bg" class="com.cs320.model.BGBean" /> <%-- this creates object of the bean --%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="background: rgb(<jsp:getProperty name="bg" property="r"/>,<%-- this is accessing values of bg object --%>
						     <jsp:getProperty name="bg" property="g"/>, 
							 <jsp:getProperty name="bg" property="b"/>)">
<p>This is BGColor2 using color values defined in Bean</p>

</body>
</html>