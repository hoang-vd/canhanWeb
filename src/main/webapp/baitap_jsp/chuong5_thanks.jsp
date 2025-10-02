<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Survey Result</title>
    <link rel="stylesheet" href="../styles/main.css" type="text/css"/>
</head>
<body style="background-color: #A4D4FF;">
<h1>Thank you for completing the survey!</h1>

<p>Here is the information you entered:</p>

<table>
    <tr>
        <td><strong>Email:</strong></td>
        <td>${user.email}</td>
    </tr>
    <tr>
        <td><strong>First Name:</strong></td>
        <td>${user.firstName}</td>
    </tr>
    <tr>
        <td><strong>Last Name:</strong></td>
        <td>${user.lastName}</td>
    </tr>
    <tr>
        <td><strong>Date of Birth:</strong></td>
        <td>${user.dob}</td>
    </tr>
    <tr>
        <td><strong>Heard From:</strong></td>
        <td>${user.heardFrom}</td>
    </tr>
    <tr>
        <td><strong>Wants Updates:</strong></td>
        <td>${user.wantsUpdates ? "Yes" : "No"}</td>
    </tr>
    <tr>
        <td><strong>Send to email:</strong></td>
        <td>${user.emailOK ? "Yes" : "No"}</td>
    </tr>
    <tr>
        <td><strong>Contact Via:</strong></td>
        <td>${user.contactVia}</td>
    </tr>
</table>

<p>To enter another survey, click the Back button in your browser or the Return button below.</p>

<form action="../baitap_jsp/chuong5_index.html" method="get">
    <input type="submit" value="Return">
</form>

</body>
</html>
