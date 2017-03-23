<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:useBean id="bg" class="com.cs320.model.BGBean" scope="session"/> <%-- this creates object of the bean --%>

<jsp:setProperty name="bg" property="r" value="255" /> <%-- value of property "r" of object "bg" is set to 255 --%>
<jsp:setProperty name="bg" property="g" param="green" /> <%-- takes value of request parameter --%>
<jsp:setProperty name="bg" property="g" /> <%-- this is equivalent to above if request parameter is "g" --%>
<jsp:setProperty name="bg" property="*" /> <%-- It sets value of any/every parameter matched in request  --%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="background: rgb(<jsp:getProperty name="bg" property="r"/>,<%-- this is accessing values of bg object --%>
						     <jsp:getProperty name="bg" property="g"/>, 
							 <jsp:getProperty name="bg" property="b"/>)">

</body>
</html>