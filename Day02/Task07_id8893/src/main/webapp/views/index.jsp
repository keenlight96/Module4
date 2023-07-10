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
<table>
    <form action="/calculate" method="get">
        <tr>
            <td colspan="2"><input type="text" name="number1"></td>
            <td colspan="2"><input type="text" name="number2"></td>
        </tr>
        <tr>
            <td>
                <button type="submit" name="button" value="add">Addition</button>
            </td>
            <td>
                <button type="submit" name="button" value="subtract">Subtraction</button>
            </td>
            <td>
                <button type="submit" name="button" value="multiple">Multiplication</button>
            </td>
            <td>
                <button type="submit" name="button" value="divide">Division</button>
            </td>
        </tr>
    </form>
</table>
</body>
</html>