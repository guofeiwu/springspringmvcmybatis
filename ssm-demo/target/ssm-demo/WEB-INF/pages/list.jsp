<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工列表</title>
</head>
<body>
	<table>
			<tr>
				<td>pid</td>
				<td>name</td>
				<td>age</td>
				<td>address</td>
			</tr>
		<c:forEach items="${persons }" var="person">
			<tr>
				<td>${person.pid }</td>
				<td>${person.name }</td>
				<td>${person.age }</td>
				<td>${person.address }</td>
			</tr>
		</c:forEach>
	
	</table>

</body>
</html>