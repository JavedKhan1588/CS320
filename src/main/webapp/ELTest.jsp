
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="ba" class="com.cs320.model.BeanA" />
<jsp:useBean id="bb" class="com.cs320.model.BeanB" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>
	<h3>BeanA</h3>
	<ul>
		<li>id: ${ba.id}</li>
		<li>name: ${ba.name}</li>
		<li>weekdays[1]: ${ba.weekdays[1]}</li>
		<li>weekdays["1"]: ${ba.weekdays["1"]}</li>
		<%-- java converts the string index into integer --%>
		<li>numbers[1]: ${ba.numbers[1]}</li>
		<%-- Java considered the list element order as array index automatically --%>
		<li>numbers["1"]: ${ba.numbers["1"]}</li>
	</ul>
	<ul>
		<li>bean0.id: ${bb.bean0.id}</li>
		<li>bean0.name: ${bb.bean0.name}</li>
		<li>beans[1].id: ${bb.beans[1].id}</li>
		<li>beans[1].name: ${bb.beans[1].name}</li>
	</ul>
	<p>2 + 3/2: ${2+3/2}</p>
	<p>"2" + 3/2: ${"2"+3/2}</p>
	<p>"2" + 3 div 2: ${ "2" + 3 div 2} </p>
	<p>${null == 'test'} </p>
	<p>${null eq 'null'} </p>
	<p>${empty ""} </p>
	<p>${empty null} </p>
	<p>${empty "null"} </p>
	<p>${"abc" lt "aac"} </p>
</body>
</html>