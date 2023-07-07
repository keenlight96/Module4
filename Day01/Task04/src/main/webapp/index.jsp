<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>

<form action="/translate">
    <input type="text" name="word">
    <button type="submit">Translate</button>
</form>

</body>
</html>