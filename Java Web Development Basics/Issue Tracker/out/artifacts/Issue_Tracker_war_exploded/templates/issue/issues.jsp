<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Issues</title>
    <link rel="stylesheet" href="static/bootstrap/css/bootstrap.css"/>
    <link rel="stylesheet" href="static/css/issues.css"/>
<body>
<br/>
<div class="container">
    <form method="get">
        <div class="row">
            <div class="col-sm-2">
                <div class="form-group">
                    <select name="status"  class="form-control" required>
                        <optgroup label="Status">
                            <option value="" disabled hidden selected>Status</option>
                            <option>All</option>
                            <option>New</option>
                            <option>Solved</option>
                        </optgroup>
                    </select>
                </div>
            </div>
            <div class="col-sm-8">
                <div class="form-group">
                    <input name="name" type="text" class="form-control" placeholder="Search">
                </div>
            </div>
            <div class="col-sm-2">
                <button type="submit" class="btn btn-default">Search</button>
            </div>
        </div>
        <div class="row">
            <a class="btn btn-success" href="/issues/add">Add Issue</a>
        </div>
    </form>
    <div class="row">
        <table class="table table-hover">
            <thead>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Status</th>
                <th>Priority</th>
                <th>Creation Date</th>
                <th>Author</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>1</td>
                <td>TomEE</td>
                <td>New</td>
                <td>High</td>
                <td>12-01-2012</td>
                <td>Teo</td>
                <td>
                    <a href="/" class="btn mini btn-primary">Edit</a>
                </td>
                <td>
                    <a href="/" class="confirm-delete mini btn btn-danger">Delete</a>
                </td>
            </tr>
            <tr>
                <td>2</td>
                <td>IntelliJ</td>
                <td>Solved</td>
                <td>Low</td>
                <td>12-01-2013</td>
                <td>Teo</td>
                <td>
                    <a href="/" class="btn mini btn-primary">Edit</a>
                </td>
                <td>
                    <a href="/" class="confirm-delete mini btn btn-danger">Delete</a>
                </td>
            </tr>
            <tr>
                <td>3</td>
                <td>CSS</td>
                <td>New</td>
                <td>Medium</td>
                <td>12-01-2013</td>
                <td>Teo</td>
                <td>
                    <a href="/" class="btn mini btn-primary">Edit</a>
                </td>
                <td>
                    <a href="/" class="confirm-delete mini btn btn-danger">Delete</a>
                </td>
            </tr>
            </tbody>
        </table>
    </div>
</div>

<script src="static/jquery/jquery.min.jss"></script>
<script src="static/bootstrap/js/bootstrap.js"></script>
<script>
    $("#issues").addClass("active");
</script>
</body>
</html>