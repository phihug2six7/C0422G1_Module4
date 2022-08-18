<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
<%--    <link rel="stylesheet" href="css/bootstrap.min.css">--%>
    <link rel="stylesheet" href="styles/bootstrap.min.css">
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
</head>
<body>
<h4>Tờ Khai Y Tế</h4>
<a href="/full/showCreate">Create</a>
<table class="table">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Name</th>
        <th scope="col">Year</th>
        <th scope="col">Gender</th>
        <th scope="col">Nation</th>
        <th scope="col">idCart</th>
        <th scope="col">travelInformation</th>
        <th scope="col">vehicleNumber</th>
        <th scope="col">seats</th>
        <th scope="col">dayStart</th>
        <th scope="col">monthStart</th>
        <th scope="col">yearsStart</th>
        <th scope="col">dayEnd</th>
        <th scope="col">monthEnd</th>
        <th scope="col">yearsEnd</th>
        <th scope="col">goCity</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${declarationList}" var="dec">
    <tr>
        <td>${dec.id}</td>
        <td>${dec.name}</td>
        <td>${dec.year}</td>
        <td>${dec.gender}</td>
        <td>${dec.nation}</td>
        <td>${dec.idCart}</td>
        <td>${dec.travelInformation}</td>
        <td>${dec.vehicleNumber}</td>
        <td>${dec.seats}</td>
        <td>${dec.dayStart}</td>
        <td>${dec.monthStart}</td>
        <td>${dec.yearsStart}</td>
        <td>${dec.dayEnd}</td>
        <td>${dec.monthEnd}</td>
        <td>${dec.yearsEnd}</td>
        <td>${dec.goCity}</td>
        <td><a href="/full/showUpdate?id=${dec.id}">Update</a></td>
        </c:forEach>
    </tr>
    </tbody>
</table>
</body>
<script src="javascript/bootstrap.min.js"></script>
<%--<script src="js/bootstrap.min.js"></script>--%>
</html>
