<%--
  Created by IntelliJ IDEA.
  User: hung
  Date: 8/16/2022
  Time: 4:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Calculator</h1>
<form action="/transfer">
    <input type="number" name="number1" placeholder="0" value="${number1}">
    <input type="number" name="number2" placeholder="0" value="${number2}">
    <div>
        <input type="submit" value="Addition(+)" name="count">
        <input type="submit" value="Subtraction(-)" name="count">
        <input type="submit" value="Multiplication(X)" name="count">
        <input type="submit" value="Division(/)" name="count">
    </div>
</form>
<p>${total}</p>
</body>
</html>
