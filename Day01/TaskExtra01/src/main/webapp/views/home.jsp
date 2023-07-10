<%--
  Created by IntelliJ IDEA.
  User: keenlight
  Date: 04/07/2023
  Time: 23:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Students</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container">
    <h2>Students Management</h2>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>#</th>
            <th>Name</th>
            <th>Email</th>
            <th>Phone Number</th>
            <th>Edit</th>
            <th>Remove</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="student" items="${students}">
            <tr>
                <td>${student.studentId}</td>
                <td>${student.name}</td>
                <td>${student.email}</td>
                <td>${student.phoneNumber}</td>
                <td><a href="/edit?studentId=${student.studentId}" class="btn btn-warning">Edit</a></td>
                <td>
                        <form action="/remove" method="get">
                            <input type="text" name="studentId" value="${student.studentId}" hidden="hidden">
                            <!-- Button to Open the Modal -->
                            <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#myModal${student.studentId}">
                                Remove
                            </button>

                            <!-- The Modal -->
                            <div class="modal" id="myModal${student.studentId}">
                                <div class="modal-dialog">
                                    <div class="modal-content">

                                        <!-- Modal Header -->
                                        <div class="modal-header">
                                            <h4 class="modal-title">Confirm remove</h4>
                                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                                        </div>

                                        <!-- Modal body -->
                                        <div class="modal-body">
                                            Do you really want to remove this student from Students Management?
                                        </div>

                                        <!-- Modal footer -->
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">
                                                Cancel
                                            </button>
                                            <button type="submit" class="btn btn-danger">Remove</button>
                                        </div>

                                    </div>
                                </div>
                            </div>
                        </form>

                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="/views/add.jsp" class="btn btn-primary" style="width: 100px">Add</a> <br> <br>
    <form action="/search" method="get">
        <button type="submit" class="btn btn-secondary" style="width: 100px">Search</button>
        <input type="text" name="name" placeholder="Input name to search">
    </form>
</div>
</body>
</html>
