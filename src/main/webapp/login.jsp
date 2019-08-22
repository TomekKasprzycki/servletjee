<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Log in page</title>
</head>
<body>

<form method="post" action="/servletjee/LoginServlet">
    <label>Podaj login</label>
    <input type="text" name="login">
    <label>Podaj hasło</label>
    <input type="text" name="password">

    <button type="submit">Zaloguj</button>

</form>


</body>
</html>
