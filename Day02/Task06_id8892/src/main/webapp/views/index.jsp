<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Sandwich Condiments" %>
</h1>
<br/>
<form action="/save">
    <input type="checkbox" id="ingredient1" name="ingredient" value="Lettuce">
    <label for="ingredient1">Lettuce</label><br>
    <input type="checkbox" id="ingredient2" name="ingredient" value="Tomato">
    <label for="ingredient2">Tomato</label><br>
    <input type="checkbox" id="ingredient3" name="ingredient" value="Mustard">
    <label for="ingredient3">Mustard</label><br>
    <input type="checkbox" id="ingredient4" name="ingredient" value="Sprouts">
    <label for="ingredient4">Sprouts</label><br>
    <button type="submit">Submit</button>
</form>
</body>
</html>