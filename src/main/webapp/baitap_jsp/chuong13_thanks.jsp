<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Murach's Java Servlets and JSP</title>
    <link rel="stylesheet" href="../styles/chuong13_main.css" type="text/css"/>    
</head>

<body>
    <div class="container">
        <h1>Thanks for Joining</h1>
        <p class="intro-text">Here is the information that you entered:</p>
        <div class="info-box">
            <p><strong>Email:</strong> <span>${user.email}</span></p>
            <p><strong>First Name:</strong> <span>${user.firstName}</span></p>
            <p><strong>Last Name:</strong> <span>${user.lastName}</span></p>
        </div>
        <p class="intro-text">To enter another email address, click Back in your browser or use the Return button below.</p>
        <form action="${pageContext.request.contextPath}/chuong13/emailList" method="post">
            <input type="hidden" name="action" value="join">
            <input type="submit" value="Return" class="btn-return">
        </form>
    </div>
</body>
</html>