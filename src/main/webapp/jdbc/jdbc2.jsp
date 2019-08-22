<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Books index</title>
</head>
<body>

<table border="1px">
    <thead>
        <td>id</td>
        <td>Title</td>
        <td>Author</td>
        <td>ISBN</td>
        <td>Action</td>
    </thead>
        <c:forEach var="book" items="${books}">
            <tr>
                <td>${book.id}</td>
                <td>${book.title}</td>
                <td>${book.author}</td>
                <td>${book.isbn}</td>
                <td>
                    <a href="<c:url value='/deleteBook?id=${book.id}'></c:url>">Delete</a>
                </td>
            </tr>
        </c:forEach>

</table>


</body>
</html>
