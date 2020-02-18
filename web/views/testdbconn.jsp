<%--
  Created by IntelliJ IDEA.
  User: Yanyshev
  Date: 18.02.2020
  Time: 14:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.sql.Connection" %>
<%@ page import="util.DbMngr" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    Connection conn = DbMngr.getConnection();
    if (conn == null){
        out.print("connection failed");
    } else {
        out.print(conn.toString() + "Conn = OK!");
    }
%>

</body>
</html>
