<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="Add" modelAttribute="userBean">
<form :input path="uname"></form>
<form :input path="pwd"></form>
<input type="submit" value="submit"/>
</form:form>
</body>
</html>