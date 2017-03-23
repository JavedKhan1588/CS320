<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:useBean id="bg" class="com.cs320.model.BGBean"/>
<jsp:setProperty name="bg" property="r" value="255"/>
<jsp:setProperty name="bg" property="g" param="green"/>
<jsp:setProperty name="bg" property="*"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="background: rgb(<jsp:getProperty name="bg" property="r"/>,<jsp:getProperty name="bg" property="g"/>, <jsp:getProperty name="bg" property="b"/>)">

</body>
</html>