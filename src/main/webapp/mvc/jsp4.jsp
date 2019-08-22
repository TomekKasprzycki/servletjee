
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Book Exercise</title>
</head>
<body>
<form action="<c:url value='/mvc14'/>" method="post">
    <p><h2>Tworzenie nowej książki</h2></p>
    <C:forEach begin="1" end="5">
        <p>
    <label>Podaj autora: </label>
    <input type="text" name="author" >
    <label>Podaj tytuł: </label>
    <input type="text" name="title">
    <label>Podaj ISBN: </label>
    <input type="text" name="isbn">
        </p>
    </C:forEach>
    <button type="submit">Wyślij</button>
</form>

</body>
</html>