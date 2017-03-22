<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<main>
    <div class="container body-content span=8 offset=2">
        <h2 style="text-align: center;">${article.articleTitle}</h2>
        <p>${article.articleContent}</p>
        <p style="font-size: 12px;color:gainsboro;">${article.authorFullName}</p>
        <div style="float:left;">
        <a href="" class="btn btn-success">Edit</a>
        <a href="" class="btn btn-danger">Delete</a>
        <a href="" class="btn btn-default">back >></a>
        </div>
    </div>
</main>