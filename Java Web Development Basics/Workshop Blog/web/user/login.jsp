<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<main>
    <div class="container body-content span=8 offset=2">
        <%--TODO: Import the error.jsp Page--%>
        <jsp:include page="../error.jsp"/>
        <div class="well">

            <form class="form-horizontal" <%--TODO: Create the correct type of form --%> method="post">
                <fieldset>
                    <legend>Login</legend>
                    <div class="form-group">
                        <label class="col-sm-4 control-label" for="user-fullname">Full Name</label>
                        <div class="col-sm-4 ">
                            <input type="text" class="form-control" id="user-fullname" name="full-name"
                                   placeholder="Full Name" required="required"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-4 control-label" for="user-password-first">Password</label>
                        <div class="col-sm-4">
                            <input type="password" class="form-control" id="user-password-first" name="password"
                                   placeholder="Password" required="required"/>
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