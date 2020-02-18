<%@ page import="java.util.List" %>
<%@ page import="entities.User" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Delete User</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <style>
        table {
            border-collapse: collapse;
            width: 100%;
        }

        th, td {
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even){background-color: #f2f2f2}

        th {
            background-color: #4CAF50;
            color: white;
        }
    </style>
</head>

<body class="w3-light-grey">

<div class="w3-container w3-blue-grey w3-opacity w3-right-align">
    <h6>Web Demo App Java EE... - Pred.Prod Task # 1</h6>
</div>

<div class="w3-container w3-center w3-padding">

    <div class="w3-card-4">
        <div class="w3-container w3-center w3-green">
            <h2 class="w3-xlarge">Delete user</h2>
        </div>
        <form method="post" class="w3-selection w3-light-grey w3-padding">
            <label>Enter user's SSN :
                <input type="text" name="ssn" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
            </label>
            <button type="submit" class="w3-btn w3-green w3-round-large w3-margin-bottom">Submit</button>
        </form>
    </div>

    <div class="w3-container w3-center w3-margin-bottom w3-padding">
        <div class="w3-card-4">
            <div class="w3-container w3-light-blue">
                <h2 class="w3-xlarge">Users List</h2>
            </div>


            <table>
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Sex</th>
                    <th>Age</th>
                    <th>Email</th>
                    <th>SSN</th>
                </tr>
                </thead>

                <tbody>
                <c:forEach items="${usrsLst}" var="user">
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.name}</td>
                        <td>${user.sex}</td>
                        <td>${user.age}</td>
                        <td>${user.email}</td>
                        <td>${user.ssn}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

</div>


<div class="w3-container w3-grey w3-opacity w3-center w3-padding">
    <button class="w3-btn w3-round-large w3-green" onclick="location.href='/'">Back to main</button>
</div>

</body>
</html>
