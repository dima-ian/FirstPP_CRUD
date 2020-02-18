<%@ page import="java.util.List" %>
<%@ page import="entities.User" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Список пользователей : </title>
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




<%--        <%--%>
<%--            List<User> users = (List<User>) request.getAttribute("usrsLst");--%>

<%--            if (users != null && !users.isEmpty()) {--%>
<%--                out.println("<ul class=\"w3-ul\">");--%>
<%--                for (User u : users) {--%>
<%--                    out.println("<li class=\"w3-hover-sand\">" + u.toString() + "</li>");--%>
<%--                }--%>
<%--                out.println("</ul>");--%>

<%--            } else out.println("<div class=\"w3-panel w3-red w3-display-container w3-card-4 w3-round\">\n"--%>
<%--                    +--%>
<%--                    "   <span onclick=\"this.parentElement.style.display='none'\"\n" +--%>
<%--                    "   class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-red w3-border w3-border-red w3-hover-border-grey\">×</span>\n" +--%>
<%--                    "   <h5>There are no users yet!</h5>\n" +--%>
<%--                    "</div>");--%>
<%--        %>--%>
    </div>
</div>

<div class="w3-container w3-grey w3-opacity w3-center w3-padding">
    <button class="w3-btn w3-round-large w3-green" onclick="location.href='/'">Back to main</button>
</div>
</body>
</html>