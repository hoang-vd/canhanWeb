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
<body class="canhan-page">
  <%@ include file="/WEB-INF/includes/nav.jspf" %>
  <div class="profile">
    <img src="assets/the3.jpg" alt="Avatar" />
    <section>
      <h2>
      Nice to meet you, I'm Vu Duc Hoang from Vietnam👋
      </h2>
      <p>Data Engineer Student in UTE.</p>
      <p>Cố gắng học nhiều thứ mới đều đều nhưng chưa thể tập trung thế mạnh vào một lĩnh vực😑.</p>
      <h3>Kiến thức</h3>
      <ul>
        <li>Củng cố lập trình hướng đối tượng và mô hình 3 lớp ứng dụng website.</li>
        <li>Nền tảng kiến thức C++, C#, T-SQL phục vụ xử lý dữ liệu.</li>
        <li>Xây dựng các script Python crawl dữ liệu và xử lý.</li>
        <li>Tạo biểu đồ trực quan hóa dữ liệu bằng Python, R, Excel.</li>
        <li>Lắp ráp cơ bản về lập trình arduino ứng dụng trong IoT.</li>
        <li>Desktop Support với Windows kiểm tra lưu lượng bất thường với Wireshark, Process explorer, TCPView,...</li>
      </ul>
      <h3>Kỹ năng chính</h3>
      <ul class="list-links">
        <li><a>Python (crawl, Selenium)</a></li><li><a>Java</a></li><li><a>Servlet/JSP/JSTL</a></li><li><a>Hibernate/JPA</a></li><li><a>C++</a></li><li><a>C#</a></li><li><a>T-SQL</a></li><li><a>HTML/CSS</a></li><li><a>Git</a></li><li><a>Wireshark (cơ bản)</a></li><li><a>Desktop Support</a></li>
      </ul>
      <h3>Sở thích</h3>
      <ul>
        <li>Ẩm thực & khám phá văn hoá món ăn địa phương</li>
        <li>Bánh ngọt & những chuyện thú vị</li>
        <li>Đọc sách luyện logic, suy luận & trinh thám</li>
        <li>Tìm hiểu về những công nghệ mới</li>
        <li>Xem các kênh YouTube review ẩm thực around the world</li>
      </ul>
      <h3>Liên hệ</h3>
      <ul class="list-links">
        <li><a href="mailto:vdh.hoang06@gmail.com">Email</a></li>
        <li><a target="_blank" href="https://github.com/hoang-vd">GitHub</a></li>
        <li><a href="tel:0909244230">Điện thoại: 0909 244 230</a></li>
      </ul>
    </section>
  </div>
  <footer class="site-footer">© <script>document.write(new Date().getFullYear())</script> Hoang • Trang cá nhân học tập</footer>
</body>
</html>
