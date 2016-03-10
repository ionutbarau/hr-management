<%--
  Created by IntelliJ IDEA.
  User: x01027037
  Date: 10.03.2016
  Time: 14:54
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
<c:forEach var="error" items="${errors.allErrors}">
  <c:out value="${error.defaultMessage}"/>
</c:forEach>
</body>
</html>
