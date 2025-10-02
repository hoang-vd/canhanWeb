<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<c:set var="pageId" value="baitap" />
<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="UTF-8" />
  <title>Bài tập | CaNhanWeb</title>
  <link rel="stylesheet" href="${ctx}/styles/site.css" />
</head>
<body class="baitap-page">
  <%@ include file="/WEB-INF/includes/nav.jspf" %>
  <main class="hero" id="email-list">
    <h1>Danh mục bài tập</h1>

    <h2>Chương 3 - 5: Form & Validation</h2>
    <ul class="list-links">
  <!-- <li><a target="_blank" href="${ctx}/go?task=chuong3_form">Ch3 Email List (HTML)</a></li>
  <li><a target="_blank" href="${ctx}/go?task=chuong3_servlet">Ch3 Servlet</a></li> -->
  <li><a target="_blank" href="${ctx}/go?task=chuong4_servlet">Ch4 Servlet</a></li>
  <li><a target="_blank" href="${ctx}/go?task=chuong5_servlet">Ch5 Form mở rộng</a></li>
    </ul>

    <h2 id="cart">Chương 6 - 9: Session, Cookies, Cart</h2>
    <ul class="list-links">
  <li><a target="_blank" href="${ctx}/go?task=chuong6p1">Ch6p1 Email List + DB</a></li>
  <li><a target="_blank" href="${ctx}/go?task=chuong6p2">Ch6p2 Survey</a></li>
  <li><a target="_blank" href="${ctx}/go?task=chuong7p1">Ch7p1 Cart (file)</a></li>
  <li><a target="_blank" href="${ctx}/go?task=chuong7p2">Ch7p2 Download + Cookies</a></li>
  <!-- <li><a target="_blank" href="${ctx}/go?task=chuong9p2">Ch9p2 Cart nâng cao</a></li> -->
    </ul>

    <h2 id="sql">Chương 12: SQL Gateway</h2>
    <ul class="list-links">
  <li><a target="_blank" href="${ctx}/go?task=chuong12_sql">SQL Gateway UI</a></li>
  <!-- <li><a target="_blank" href="${ctx}/go?task=chuong12_sql">Servlet thực thi</a></li> -->
    </ul>

    <h2 id="jpa">Chương 13: JPA Email List</h2>
    <ul class="list-links">
  <li><a target="_blank" href="${ctx}/go?task=chuong13_jpa">Form JPA</a></li>
  <!-- <li><a target="_blank" href="${ctx}/go?task=chuong13_jpa">Servlet JPA</a></li> -->
    </ul>
  </main>
  <footer class="site-footer">© <script>document.write(new Date().getFullYear())</script> CaNhanWeb • Bài tập JSP/Servlet</footer>
</body>
</html>
