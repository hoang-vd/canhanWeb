<!doctype html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Murach's Java Servlets and JSP</title>
        <link rel="stylesheet" href="../styles/chuong4_survey.css" type="text/css"/>
    </head>

    <body>
        <div class="survey-form" style="max-width: 500px; margin: 40px auto;">
            <img src="../assets/murachlogo.jpg" alt="Murach Logo" style="width:150px; display:block; margin-bottom:10px;">
            <h1>Thanks for joining our email list</h1>
            <p>Here is the information that you entered:</p>
            <table style="width:100%; margin-bottom: 1em;">
                <tr>
                    <td class="right"><label>Email:</label></td>
                    <td><span>${user.email}</span></td>
                </tr>
                <tr>
                    <td class="right"><label>First Name:</label></td>
                    <td><span>${user.firstName}</span></td>
                </tr>
                <tr>
                    <td class="right"><label>Last Name:</label></td>
                    <td><span>${user.lastName}</span></td>
                </tr>
            </table>
            <p>To enter another email address, click on the Back button in your browser or the Return button below.</p>
            <form action="../baitap_jsp/chuong4_index.html" method="get">
                <input type="submit" value="Return">
            </form>
        </div>
    </body>
</html>