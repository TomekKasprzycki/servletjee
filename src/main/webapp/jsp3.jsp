
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Zadanie 3</title>
</head>
<body>

<p>Paramert a: ${empty param.a ? "Nie podano" : param.a}</p>

<p>Parametr b: ${empty param.b ? "Nie podano":param.b}</p>

<p>Wartość ciasteczka: ${cookie.foo.value}</p>

</body>
</html>
