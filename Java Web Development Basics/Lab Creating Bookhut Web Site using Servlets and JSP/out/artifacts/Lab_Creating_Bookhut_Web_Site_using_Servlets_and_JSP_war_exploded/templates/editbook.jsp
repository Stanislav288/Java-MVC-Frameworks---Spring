<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Book</title>
</head>
<body>
    <jsp:include page="menu.jsp"/>
    <c:set var="book" value="${book}"/>
    <form  method="post">
        Title<input type="text" name="title" value="${book.title}" readonly/>
        Author<input type="text" name="author" value="${book.author}"/>
        Pages<input type="text" name="pages" value="${book.pages}"/>
        <input type="submit" name="edit" value="Edit">
    </form>
</body>
</html>
