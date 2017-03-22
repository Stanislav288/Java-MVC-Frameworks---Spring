<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<c:set var="user-id" scope="session" value="${user-id}"/>--%>
<%@ page session="true" %>
<header>
    <div class="navbar navbar-default navbar-static-top" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <a <%--TODO: Your route here --%> class="navbar-brand">SOFTUNI BLOG</a>

                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            </div>
            <div class="navbar-collapse collapse">
                <ul class="nav navbar-nav navbar-right">
                    <c:choose>
                        <c:when test="${userId==null}">
                            <li>
                                <a <%--TODO: Your route here --%> href="${pageContext.request.contextPath}/register">
                                    REGISTER
                                </a>
                            </li>
                            <li>
                                <a <%--TODO: Your route here --%> href="${pageContext.request.contextPath}/login">
                                    LOGIN
                                </a>
                            </li>
                        </c:when>

                        <c:otherwise>
                            <li>
                                <a <%--TODO: Your route here --%>
                                        href="${pageContext.request.contextPath}/article/create">
                                    Create Article
                                </a>
                            </li>
                            <li>
                                <a <%--TODO: Your route here --%> href="${pageContext.request.contextPath}/profile">
                                    My Profile
                                </a>
                            </li>
                            <li>
                                <a <%--TODO: Your route here --%> href="${pageContext.request.contextPath}/logout">
                                    Logout
                                </a>
                            </li>
                        </c:otherwise>
                    </c:choose>
                </ul>
            </div>
        </div>
    </div>
</header>