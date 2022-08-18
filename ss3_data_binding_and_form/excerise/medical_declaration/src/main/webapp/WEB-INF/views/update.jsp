<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3 align="center">TỜ KHAI Y TẾ</h3>
<h4 align="center">ĐÂY LÀ TÀI LIỆU QUAN TRỌNG, THÔNG TIN CỦA ANH/CHỊ SẼ GIÚP CƠ QUAN Y TẾ LIÊN LẠC KHI CẦN THIẾT ĐỂ
    PHÒNG CHỐNG DỊCH BỆNH TRUYỀN NHIỄM</h4>
<h5 align="center" style="color:red">Khuyến cáo:Khai báo thông tin sai là vi phạm pháp luật Việt Nam có thể xử lý hình
    sự</h5>
<form:form action="update?id=${declaration.id}" method="post" modelAttribute="declaration">
    <div>
        <b>Họ tên (ghi chữ IN HOA)<b class="lame">(*)</b></b>
        <div>
            <form:input path="name"></form:input>
        </div>
    </div>

    <div>
        <b>Năm sinh<b class="lame">(*)</b></b>
        <form:select path="year" items="${year}"></form:select>
        <b>Giới tính <b class="lame">(*)</b></b>
        <form:select path="gender" items="${gender}"></form:select>
        <b>Quốc tịch <b class="lame">(*)</b> </b>
        <form:select path="nation" items="${nation}"></form:select>
    </div>
    <div>
        <b>Số hộ chiếu hoặc số CMND hoặc giấy thông hành hợp pháp khác <b class="lame">(*)</b> </b>
        <div>
            <form:input path="idCart"></form:input>
        </div>
    </div>
    <div>
        <b>Thông tin đi lại <b class="lame">(*)</b> </b>
        <div>
            <form:radiobuttons path="travelInformation" items="${information}"></form:radiobuttons>
        </div>
    </div>
    <div>
        <b>Số hiệu phương tiện</b>
        <form:input path="vehicleNumber"></form:input>
        <b>Số ghế</b>
        <form:input path="seats"></form:input>
    </div>
    <div>
        <b>Ngày khởi hành <b class="lame">(*)</b> </b>
        <form:select path="dayStart" items="${dayStart}"></form:select>
        <form:select path="monthStart" items="${monthStart}"></form:select>
        <form:select path="yearsStart" items="${yearStart}"></form:select>
        <b>Ngày kết thúc <b class="lame">(*)</b></b>
        <form:select path="dayEnd" items="${dayEnd}"></form:select>
        <form:select path="monthEnd" items="${monthEnd}"></form:select>
        <form:select path="yearsEnd" items="${yearsEnd}"></form:select>
    </div>
    <div>
        <button type="submit">Gửi tờ khai</button>
    </div>
</form:form>
</body>
</html>
