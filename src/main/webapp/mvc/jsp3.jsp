
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Book Exercise</title>
</head>
<body>
<form action="<c:url value='/mvc13'/>" method="post">
    <p><h2>Tworzenie nowej książki</h2></p>
    <label>Podaj autora: </label>
    <input type="text" name="author" >
    <label>Podaj tytuł: </label>
    <input type="text" name="title">
    <label>Podaj ISBN: </label>
    <input type="text" name="isbn">
    <button type="submit">Wyślij</button>
</form>


</body>
</html>
