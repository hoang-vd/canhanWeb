<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="pageId" value="home" />
<!DOCTYPE html>
<html lang="vi">
<head>
	<meta charset="UTF-8" />
	<title>Trang chủ</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/styles/site.css" />
</head>
<body class="home-page">
	<%@ include file="/WEB-INF/includes/nav.jspf" %>
	<header class="hero">
		<h1>Chào mừng đến với không gian học tập</h1>
		<div class="grid">
			<div class="card">
				<span class="badge">1st</span>
				<h3>Email List (Ch3 → Ch5)</h3>
				<p>Form nhập và hiển thị thông tin người dùng, luyện xử lý POST/GET.</p>
				<a class="more" href="${pageContext.request.contextPath}/baitap.jsp#email-list">Xem chi tiết →</a>
			</div>
			<div class="card">
				<h3>Cart & Download</h3>
				<p>Quản lý giỏ hàng, cookies và đăng ký tải nội dung.</p>
				<a class="more" href="${pageContext.request.contextPath}/baitap.jsp#cart">Đi tới bài tập →</a>
			</div>
			<div class="card">
				<h3>SQL Gateway</h3>
				<p>Thực thi truy vấn đơn giản lên database qua giao diện web.</p>
				<a class="more" href="${pageContext.request.contextPath}/baitap.jsp#sql">Mở gateway →</a>
			</div>
			<div class="card">
				<h3>JPA Email List</h3>
				<p>Thao tác với Hibernate/JPA trong chương 13 (dùng Supabase).</p>
				<a class="more" href="${pageContext.request.contextPath}/baitap.jsp#jpa">Truy cập →</a>
			</div>
		</div>
	</header>
	<footer class="site-footer">© <script>document.write(new Date().getFullYear())</script> CaNhanWeb • Demo học tập JSP/Servlet</footer>
</body>
</html>
