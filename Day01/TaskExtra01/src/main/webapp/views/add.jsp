<%--
  Created by IntelliJ IDEA.
  User: keenlight
  Date: 05/07/2023
  Time: 00:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container">
    <h2>Add a new Student</h2>
    <form action="/add" method="post">
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>Name</th>
                <th>Email</th>
                <th>Phone number</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td><input type="text" name="name"></td>
                <td><input type="text" name="email"></td>
                <td><input type="text" name="phoneNumber"></td>
            </tr>
            </tbody>
        </table>
        <button type="submit" class="btn btn-primary">Submit</button>
        <a href="/home" class="btn btn-danger">Cancel</a>
    </form>
</div>
</body>
</html>
