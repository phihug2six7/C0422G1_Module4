<%--
  Created by IntelliJ IDEA.
  User: hung
  Date: 8/16/2022
  Time: 2:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Sandwich Condiments</h1>
<form action="/save">
    <c:forEach items="${list}" var="choose">
        <input type="checkbox" name="condiment" value="${choose}"> ${choose}
    </c:forEach>
    <div>
        <button type="submit">Submit</button>
    </div>
</form>

<c:forEach items="${condimentUser}" var="condimentUserVar">
    <p> ${condimentUserVar} </p>
</c:forEach>
</body>
</html>
