<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Murach's Java Servlets and JSP</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/chuong8_main.css" type="text/css"/>
</head>

<body>
<div class="container">
    <h1>Thanks for joining our email list</h1>

    <p>Here is the information that you entered:</p>

    <!-- Hiển thị thông tin user vừa thêm -->
    <label>Email:</label>
    <span>${sessionScope.user.email}</span><br>

    <label>First Name:</label>
    <span>${sessionScope.user.firstName}</span><br>

    <label>Last Name:</label>
    <span>${sessionScope.user.lastName}</span><br>

    <hr>

    <!-- Hiển thị ngày hiện tại -->
    <p><strong>Current Date:</strong> ${requestScope.currentDate}</p>

    <!-- Hiển thị 2 user đầu tiên trong danh sách -->
    <p><strong>First two users in the list:</strong></p>
    <c:forEach var="u" items="${sessionScope.users}" begin="0" end="1">
        <p>${u.firstName} ${u.lastName} (${u.email})</p>
    </c:forEach>

    <!-- Hiển thị email CSKH từ context-param -->
    <p><strong>Customer Service Email:</strong> ${initParam.custServEmail}</p>

    <p>To enter another email address, click on the Back
    button in your browser or the Return button shown
    below.</p>

    <form action="" method="get">
        <input type="hidden" name="action" value="join">
        <input type="submit" value="Return">
    </form>
</div>
</body>
</html>
