<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<c:set var="pageId" value="canhan" />
<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="UTF-8" />
  <title>Thông tin cá nhân | CaNhanWeb</title>
  <link rel="stylesheet" href="${ctx}/styles/site.css" />
</head>
<body>
  <%@ include file="/WEB-INF/includes/nav.jspf" %>
  <div class="profile">
    <img src="https://via.placeholder.com/180x180.png?text=Avatar" alt="Avatar" />
    <section>
      <h2>Xin chào, mình là Hoang 👋</h2>
      <p>Lập trình viên đang luyện tập nền tảng Java Web: Servlets, JSP, JSTL, JDBC, Hibernate/JPA và các kỹ thuật quản lý session, cookie, validation, MVC cơ bản.</p>
      <p>Các mục tiêu hiện tại:
        <ul>
          <li>Củng cố nền tảng Java EE cốt lõi.</li>
          <li>Xây dựng thói quen dự án rõ ràng: cấu trúc thư mục, mapping chuẩn hóa.</li>
          <li>Chuẩn bị bước chuyển sang Spring Boot sau khi nắm vững cơ bản.</li>
        </ul>
      </p>
      <h3>Kỹ năng chính</h3>
      <ul class="list-links">
        <li><a>Java</a></li><li><a>Servlet/JSP</a></li><li><a>JSTL</a></li><li><a>JDBC</a></li><li><a>Hibernate</a></li><li><a>HTML/CSS</a></li><li><a>Git</a></li>
      </ul>
      <h3>Liên hệ</h3>
      <ul class="list-links">
        <li><a href="mailto:email@example.com">Email</a></li>
        <li><a target="_blank" href="https://github.com/">GitHub</a></li>
        <li><a target="_blank" href="https://www.linkedin.com/">LinkedIn</a></li>
      </ul>
    </section>
  </div>
  <footer class="site-footer">© <script>document.write(new Date().getFullYear())</script> Hoang • Trang cá nhân học tập</footer>
</body>
</html>
