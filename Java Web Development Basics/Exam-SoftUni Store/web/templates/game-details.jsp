<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            <div class="col-12 text-center">

                <h1 class="display-3">${game.title}</h1>
                <br/>

                <iframe width="560" height="315" src="https://www.youtube.com/embed/${game.trailer}" frameborder="0"
                        allowfullscreen></iframe>

                <br/>
                <br/>

                <p>${game.description}</p>

                <p><strong>Price</strong> - ${game.price}&euro;</p>
                <p><strong>Size</strong> - ${game.size} GB</p>
                <p><strong>Release Date</strong> - ${game.releaseDate}</p>

                <a class="btn btn-outline-primary" href="${pageContext.request.contextPath}/">Back</a>
                <c:choose>
                    <c:when test="${sessionScope.user != null && sessionScope.user.getAdmin()==true}">
                        <a class="btn btn-warning" href="${pageContext.request.contextPath}/game/edit/${games.get(i).id}">Edit</a>
                        <a class="btn btn-danger" href="${pageContext.request.contextPath}/game/delete/${games.get(i).id}">Delete</a>
                    </c:when>
                </c:choose>
                <a class="btn btn-primary" href="#">Buy</a>

                <br/>
                <br/>

            </div>
        </div>
    </div>
</main>
<br/>

<!--Footer-->
<jsp:include page="../fragments/footer.jsp"/>

<jsp:include page="../fragments/script-bundle.jsp"/>
</body>
</html>