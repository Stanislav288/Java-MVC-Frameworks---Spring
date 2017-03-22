<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign Up</title>
</head>
<body>
    <jsp:include page="menu.jsp"></jsp:include>
    <form method="post">
        Username<input type="text" name="username">
        Password<input type="text" name="password">
        <input type="submit" name="signup" value="Sign Up">
    </form>
</body>
</html>
