<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Murach's Java Servlets and JSP</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/chuong7p2_main.css" type="text/css"/>
</head>
<body>

<h1>List of albums</h1>

<p>
<a href="${pageContext.request.contextPath}/chuong7p2/download?action=checkUser&amp;productCode=8601">
    86 (the band) - True Life Songs and Pictures
</a><br>

<a href="${pageContext.request.contextPath}/chuong7p2/download?action=checkUser&amp;productCode=pf01">
    Paddlefoot - The First CD
</a><br>

<a href="${pageContext.request.contextPath}/chuong7p2/download?action=checkUser&amp;productCode=pf02">
    Paddlefoot - The Second CD
</a><br>

<a href="${pageContext.request.contextPath}/chuong7p2/download?action=checkUser&amp;productCode=jr01">
    Joe Rut - Genuine Wood Grained Finish
</a>
</p>

</body>
</html>