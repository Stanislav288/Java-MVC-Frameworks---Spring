<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Book</title>
</head>
    <body>
        <jsp:include page="menu.jsp"></jsp:include>
        <form action="/add" method="post">
            Title<input type="text" name="title">
            Author<input type="text" name="author">
            Pages<input type="text" name="pages">
            <input type="submit" name="add" value="Add">
        </form>
    </body>
</html>
