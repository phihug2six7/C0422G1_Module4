<%--
  Created by IntelliJ IDEA.
  User: hung
  Date: 8/12/2022
  Time: 3:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Ứng dụng chuyển đổi tiền tệ</h1>
<form action="convert">
    <div>
        <label>USD:</label>
        <input type="number" name="usd" value="${usd}">
        <button type="submit">Chuyển</button>
    </div>
</form>
<div>
    <label>VND:</label>
    <input type="number" value="${vnd}">
</div>
</body>
</html>
