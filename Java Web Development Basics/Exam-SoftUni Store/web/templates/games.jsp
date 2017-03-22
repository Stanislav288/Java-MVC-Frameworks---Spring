<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <title>Game Store</title>
    <meta charset="UTF-8">
    <link href="/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
</head>
<body>

<jsp:include page="../fragments/header.jsp"/>
<!--Body of the store-->

<main>
    <div class="container">
        <div class="row">
            <h2 class="m-1">All Games &ndash;&nbsp;</h2> <a href="${pageContext.request.contextPath}/game/add"
                                                            class="btn btn-warning m-1"><strong>+</strong> Add
            Game</a>
            <table class="table table-striped table-hover">
                <thead>
                <tr>
                    <th>#</th>
                    <th>Name</th>
                    <th>Size</th>
                    <th>Price</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="i" begin="0" end="${games.size()-1}">
                    <tr
                            <c:if test="${i%2==0}">class="table-warning"</c:if>
                    >
                        <th scope="row">${games.get(i).id}</th>
                        <td>${games.get(i).title}</td>
                        <td>${games.get(i).size} GB</td>
                        <td>${games.get(i).price} &euro;</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/game/edit/${games.get(i).id}" class="btn btn-warning btn-sm">Edit</a>
                            <a href="${pageContext.request.contextPath}/game/delete/${games.get(i).id}" class="btn btn-danger btn-sm">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

        </div>
    </div>
</main>


<!--Footer-->
<jsp:include page="../fragments/footer.jsp"/>

<jsp:include page="../fragments/script-bundle.jsp"/>
</body>
</html>