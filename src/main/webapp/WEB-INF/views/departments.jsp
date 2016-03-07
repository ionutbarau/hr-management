<%--
  Created by IntelliJ IDEA.
  User: x01027037
  Date: 07.03.2016
  Time: 13:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>
Departments<br/>
<c:forEach var="dept" items="${departmentList}">
    <c:out value="${dept.departmentId}"/>-<c:out value="${dept.departmentName}"/> <br/>
</c:forEach>
</body>
</html>
