<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: hung
  Date: 8/17/2022
  Time: 11:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Settings</h1>
<form:form action="/details" modelAttribute="email" method="post">
    <div>
        <label>
            Languages
        </label>
        <form:select path="languages" items="${listLanguage}"></form:select>
    </div>
    <div>
        <label>
            Page Size:
        </label>
        <form:select path="pageSize" items="${listSizePage}"></form:select>
    </div>
    <div>
        <label>
            Spam filter
        </label>
        <form:checkbox path="spamsFilter"></form:checkbox>
    </div>
    <div>
        <label>
            Signature
        </label>
        <form:textarea path="signature"></form:textarea>
    </div>
    <div>
        <button type="submit">Update</button>
        <button type="reset">Cancel</button>
    </div>
</form:form>
</body>
</html>
