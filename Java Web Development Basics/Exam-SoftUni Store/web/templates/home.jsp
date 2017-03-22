<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
            <div class="col-12">
                <div class="text-center"><h1 class="display-3">SoftUni Store</h1></div>

                <form class="form-inline">
                    Filter:
                    <input type="submit" name="filter" class="btn btn-link" value="All"/>
                    <input type="submit" name="filter" class="btn btn-link" value="Owned"/>
                </form>


                <c:forEach var="i" begin="1" end="${games.size()}">
                    <c:if test="${i%3==0}">
                        <div class="card-group"></c:if>
                    <div class="card col-4 thumbnail">

                        <img
                                class="card-image-top img-fluid img-thumbnail"
                                onerror="this.src='https://i.ytimg.com/vi/${game.imageThumbnail}/maxresdefault.jpg';"
                                src="${game.imageThumbnail}">

                        <div class="card-block">
                            <h4 class="card-title">${games.get(i-1).title}</h4>
                            <p class="card-text"><strong>Price</strong> - ${games.get(i-1).price}&euro;</p>
                            <p class="card-text"><strong>Size</strong> - ${games.get(i-1).size} GB</p>
                            <p class="card-text">${fn:substring(games.get(i-1).description, 0, 300)}</p>
                        </div>

                        <c:choose>
                            <c:when test="${sessionScope.user != null && sessionScope.user.getAdmin()==true}">
                                <div class="card-footer">
                                    <a class="card-button btn btn-warning" name="edit"
                                       href="${pageContext.request.contextPath}/game/edit/${games.get(i-1).id}">Edit</a>
                                    <a class="card-button btn btn-danger" name="delete"
                                       href="${pageContext.request.contextPath}/game/delete/${games.get(i-1).id}">Delete</a>

                                    <a class="card-button btn btn-outline-primary" name="info" href="#">Info</a>
                                    <a class="card-button btn btn-primary" name="buy" href="#">Buy</a>
                                </div
                            </c:when>
                            <c:otherwise>
                                <div class="card-footer">
                                    <a class="card-button btn btn-outline-primary" name="info"
                                       href="${pageContext.request.contextPath}/game/details/${games.get(i-1).id}">Info</a>
                                    <a class="card-button btn btn-primary" name="buy" href="#">Buy</a>
                                </div>
                            </c:otherwise>
                        </c:choose>
                    </div>
                    <c:if test="${i%3==0}">
                        </div class="card-group"></c:if>
                </c:forEach>
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