<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="app.models.bindingModels.LoginModel" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
    <body>
        <a href="/">Home</a>
        <a href="/signup">Sign Up</a>
        <%
            LoginModel loginModel = (LoginModel) session.getAttribute("LOGIN_MODEL");
            String username = null;
            if(loginModel!=null){
                username=loginModel.getUsername();
                request.setAttribute("USERNAME",username);
            }
        %>
        <c:set var="username" value="${USERNAME}" scope="session"/>
        <c:choose>
            <c:when test="${username!=null}">
                <a href="/signout">Sign out(${USERNAME})</a>
            </c:when>
            <c:otherwise>
                <a href="/signin">Sign In</a>
            </c:otherwise>
        </c:choose>
        <a href="/add">Add Book</a>
        <a href="/shelves">Shelves</a>
    </body>
</html>
