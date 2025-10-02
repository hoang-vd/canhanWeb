<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="chuong6p1_header.jsp" />

<div class="container">
    <h1>Thanks for Joining Our Email List</h1>
    <p class="intro-text">Here is the information that you entered:</p>

    <div class="info-box">
        <p><strong>Email:</strong> <span>${user.email}</span></p>
        <p><strong>First Name:</strong> <span>${user.firstName}</span></p>
        <p><strong>Last Name:</strong> <span>${user.lastName}</span></p>
    </div>

    <p class="intro-text">
        To enter another email address, click the Back button in your browser or use the Return button below.
    </p>

    <form action="" method="post" class="form-box">
        <input type="hidden" name="action" value="join">
        <input type="submit" value="Return" class="btn-submit">
    </form>
</div>

<c:import url="chuong6p1_footer.jsp" />
