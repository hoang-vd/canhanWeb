<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Survey Result</title>
    <link rel="stylesheet" href="../styles/chuong6p2_main.css" type="text/css"/>
</head>
<body>

<div class="container">
    <h1>Thanks for taking our survey!</h1>
    <p>Here is the information that you entered:</p>

    <label>Email:</label>
    <span>${user.email}</span><br>

    <label>First Name:</label>
    <span>${user.firstName}</span><br>

    <label>Last Name:</label>
    <span>${user.lastName}</span><br>

    <label>Heard From:</label>
    <span>${user.heardFrom}</span><br>

    <label>Updates:</label>
    <span>${user.wantsUpdates}</span><br>

    <!-- step 8 -->
    <c:if test="${user.wantsUpdates == 'Yes'}">
        <label>Contact Via:</label>
        <span>${user.contactVia}</span><br>
    </c:if>
</div>

</body>
</html>
