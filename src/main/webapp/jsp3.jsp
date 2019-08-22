<%--
  Created by IntelliJ IDEA.
  User: tomas
  Date: 11.08.2019
  Time: 09:56
  To change this template use File | Settings | File Templates.
--%>
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
