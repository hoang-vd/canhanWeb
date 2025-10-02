<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Nếu truy cập trực tiếp mà chưa có danh sách products trong session thì forward sang servlet để load -->
<c:if test="${empty products}">
    <!-- Forward to servlet that loads product list (must use absolute path). -->
    <jsp:forward page="/chuong9p2/products" />
</c:if>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Murach's Java Servlets and JSP</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/chuong9p2_main.css" type="text/css"/>
</head>
<body>

<h1>CD list</h1>
<table>
    <tr>
        <th>Description</th>
        <th class="right">Price</th>
        <th>&nbsp;</th>
    </tr>

    <!-- Vòng lặp qua danh sách sản phẩm -->
    <c:forEach var="product" items="${products}">
        <tr>
            <td><c:out value="${product.description}" /></td>
            <td class="right"><c:out value="${product.price}" /></td>
            <td>
                <form action="../chuong9p2/cart" method="post">
                    <input type="hidden" name="productCode" value="${product.code}">
                    <input type="submit" value="Add To Cart">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
