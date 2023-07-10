<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>

<form action="/index" method="post">
    <input type="text" name="email" placeholder="email">
    <button type="submit">Submit</button>
</form>
</body>
</html>