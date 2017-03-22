<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<main>
    <div class="container body-content span=8 offset=2">
        <jsp:include page="../error.jsp"/>
        <div class="well">

            <form class="form-horizontal" <%--TODO: Create the correct type of form --%> method="post">
                <fieldset>
                    <legend>New Article</legend>
                    <div class="form-group">
                        <label class="col-sm-4 control-label" for="article-title">Article Title</label>
                        <div class="col-sm-4 ">
                            <input type="text" class="form-control" id="article-title" name="articleTitle"
                                   placeholder="Article Title" required="required"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-4 control-label" for="content">Content</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="content" name="content"
                                   required="required"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-4 col-sm-offset-4">
                            <a class="btn btn-default" <%--TODO: It should redirect to the home page --%> href="/">Cancel</a>
                            <input type="submit" value="Submit" class="btn btn-primary"/>
                        </div>
                    </div>
                </fieldset>
            </form>
        </div>
    </div>
</main>