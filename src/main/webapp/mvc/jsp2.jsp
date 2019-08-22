
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>MVC 2</title>
</head>
<body>
<ul>
<c:forEach var="currentNumber" begin="${start}" end="${end}">
        <li>${currentNumber}</li>
</c:forEach>
</ul>

</body>
</html>
