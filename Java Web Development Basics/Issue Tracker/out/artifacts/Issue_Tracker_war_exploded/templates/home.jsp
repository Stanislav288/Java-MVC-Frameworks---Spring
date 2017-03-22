<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Home</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap/css/bootstrap.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/home.css"/>
</head>
<body>
<jsp:include page="menu.jsp"/>
<div class="container">
    <h1 id="welcome" class="h1">Welcome to Issue Tracker</h1>
</div>
<script src="${pageContext.request.contextPath}/static/jquery/jquery.min.jss"></script>
<script src="${pageContext.request.contextPath}/static/bootstrap/js/bootstrap.js"></script>
<script>
    $("#home").addClass("active");
</script>
</body>
</html>
