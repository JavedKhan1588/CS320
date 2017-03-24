<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Request Info: ${pageContext.request.method}</title>
</head>
<body>
Request Info: ${pageContext.request.method}<br/>
Remote User: ${pageContext.request.remoteUser}<br/>
Remote Addr: ${pageContext.request.remoteAddr}<br/>
Request Param a and b: ${param.a}, ${param.b}<br/><%-- getting request prameters --%>
Request Param a and b: ${param["a"]}, ${param["b"]} <%--same as above --%>
Cookie JSESIONS value: ${cookie["JSESSIONID"].value} 
</body>
</html>