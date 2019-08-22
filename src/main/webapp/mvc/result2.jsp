
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Resultat</title>
</head>
<body>

<table>
    <thead>
    <td>Autor</td>
    <td>Tytuł</td>
    <td>isbn</td>
    </thead>
    <c:forEach var="book" items="${books}">
    <tr>
        <td>${book.author}</td>
        <td>${book.title}</td>
        <td>${book.isbn}</td>
    </tr>
    </c:forEach>
</table>

</body>
</html>
