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
                <div class="text-center"><h1 class="display-3">Your Cart</h1></div>
                <br/>
                <div class="list-group">
                    <div class="list-group-item">
                        <a class="btn btn-outline-danger btn-lg" href="#">X</a>
                        <div class="media col-3">
                            <figure class="pull-left">
                                <a href="#">
                                    <img
                                            class="card-image-top img-fluid img-thumbnail"
                                            onerror="this.src='https://i.ytimg.com/vi/BqJyluskTfM/maxresdefault.jpg';"
                                            src="https://i.ytimg.com/vi/BqJyluskTfM/maxresdefault.jpg"></a>
                            </figure>
                        </div>
                        <div class="col-md-6">
                            <a href="#"><h4 class="list-group-item-heading"> Mass Effect Andromeda </h4></a>
                            <p class="list-group-item-text"> Mass Effect: Andromeda is an action role-playing game in which the player takes control of either Scott or Sara Ryder from a third-person perspective.
                            </p>
                        </div>
                        <div class="col-md-2 text-center mr-auto">
                            <h2> 60&euro; </h2>
                        </div>
                    </div>

                    <div class="list-group-item">
                        <a class="btn btn-outline-danger btn-lg" href="#">X</a>
                        <div class="media col-3">
                            <figure class="pull-left">
                                <a href="#">
                                    <img
                                            class="card-image-top img-fluid img-thumbnail"
                                            onerror="this.src='https://i.ytimg.com/vi/BqJyluskTfM/maxresdefault.jpg';"
                                            src="https://i.ytimg.com/vi/BqJyluskTfM/maxresdefault.jpg"></a>
                            </figure>
                        </div>
                        <div class="col-md-6">
                            <a href="#"><h4 class="list-group-item-heading"> Mass Effect Andromeda </h4></a>
                            <p class="list-group-item-text"> Mass Effect: Andromeda is an action role-playing game in which the player takes control of either Scott or Sara Ryder from a third-person perspective.
                            </p>
                        </div>
                        <div class="col-md-2 text-center mr-auto">
                            <h2> 60&euro; </h2>
                        </div>
                    </div>
                </div>
                <br/>
                <div class="col-8 offset-2 my-3 text-center">
                    <h1><strong>Total Price - </strong> 120 &euro;</h1>
                </div>
                <div class="col-8 offset-2 my-3">
                    <form>

                        <input type="submit" class="btn btn-success btn-lg btn-block"
                               value="Order"/>
                    </form>
                </div>
                <br/>
            </div>
        </div>
    </div>
</main>

<!--Footer-->
<jsp:include page="../fragments/footer.jsp"/>

<jsp:include page="../fragments/script-bundle.jsp"/>
</body>
</html>