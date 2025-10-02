<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/baitap_jsp/chuong6p1_header.jsp" />

<div class="container">
    <h1>Join Our Email List</h1>
    <p class="intro-text">
        To join our email list, enter your name and email address below.
    </p>

    <c:if test="${message != null}">
        <p class="error-message"><i>${message}</i></p>
    </c:if>

    <form action="${pageContext.request.contextPath}/chuong6p1/emailList" method="post" class="email-form">
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

<c:import url="/baitap_jsp/chuong6p1_footer.jsp" />
