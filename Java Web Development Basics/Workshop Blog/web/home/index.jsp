<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<main>
    <div class="container body-content span=8 offset=2">
        <jsp:include page="../error.jsp"/>
        <c:forEach begin="0" end="${articles.size()-1}" varStatus="loop">
            <%--<c:choose>--%>
                <%--<c:when test="${loop.index%2==0}">--%>
                    <div class="col-sm-6">
                        <h2 style="text-align:center;">${articles.get(loop.index).articleTitle}</h2>
                        <p>${articles.get(loop.index).articleContent}</p>
                        <p>${articles.get(loop.index).authorFullName}</p>
                        <a href="/article/${articles.get(loop.index).id}" class="btn btn-default">Read more >></a>
                    </div>
                <%--</c:when>--%>
                <%--<c:otherwise>--%>
                    <%--<div class="col-sm-6">--%>
                        <%--<h2 style="text-align:center;">${articles.get(loop.index).articleTitle}</h2>--%>
                        <%--<p>${articles.get(loop.index).articleContent}</p>--%>
                        <%--<p>${articles.get(loop.index).authorFullName}</p>--%>
                        <%--<a href="/article/${articles.get(loop.index).id}" class="btn btn-default">Read more >></a>--%>
                    <%--</div>--%>
                <%--</c:otherwise>--%>
            <%--</c:choose>--%>
        </c:forEach>
    </div>
</main>