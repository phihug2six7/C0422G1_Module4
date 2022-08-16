<%--
  Created by IntelliJ IDEA.
  User: hung
  Date: 8/15/2022
  Time: 10:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Ứng dụng từ điển</h1>
<form action="convert" method="post">
    <div>
        <label>Tiếng Anh</label>
        <input type="text" name="word" value="">
    </div>
    <div>
        <button type="submit">Chuyển Đổi</button>
    </div>
</form>
<h1>${result}</h1>
</body>
</html>
