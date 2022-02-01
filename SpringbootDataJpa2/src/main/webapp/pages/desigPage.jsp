<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<body>
 <form>
            <table border="1">
                <caption>Employee List on Designation</caption>
                <tr>
                    <th>Employee ID</th>
                    <th>Employee Name</th>
                 
                </tr>
              <c:forEach var="row" items="${list}">   
                    <tr>
                        <td><c:out value="${row.id}"/></td>
                           <td><c:out value="${row.name}"/></td>
                       
                           
                           
                    </tr>
                </c:forEach>
            </table>
        </form>
</body>
</html>