<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Sandwich Condiments" %>
</h1>
<br/>
<p>Result: </p>
<c:forEach var="condiment" items="${condiments}">
    <p>${condiment}</p>
</c:forEach>
</body>
</html>