<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Murach's Java Servlets and JSP</title>
    <link rel="stylesheet" href="../styles/chuong13_main.css" type="text/css"/>
</head>
<body>
    <div class="container">
        <h1>Join Our Email List</h1>
        <p class="intro-text">To join our email list, enter your name and email address below.</p>
        <c:if test="${message != null}">
            <p class="error-message"><i>${message}</i></p>
        </c:if>
        <form action="${pageContext.request.contextPath}/chuong13/emailList" method="post">
            <input type="hidden" name="action" value="add">
            <div class="form-group">
                <label>Email:</label>
                <input type="email" name="email" value="${user.email}" required>
            </div>
            <div class="form-group">
                <label>First Name:</label>
                <input type="text" name="firstName" value="${user.firstName}" required>
            </div>
            <div class="form-group">
                <label>Last Name:</label>
                <input type="text" name="lastName" value="${user.lastName}" required>
            </div>
            <div class="form-group">
                <input type="submit" value="Join Now" class="btn-submit">
            </div>
        </form>
    </div>
</body>
</html>