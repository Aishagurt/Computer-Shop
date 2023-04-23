<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>

    <%@include file="head.jsp"%>

</head>

<body>

<%@include file="navbar.jsp"%>

<div class="container" style="min-height: 500px;">

    <div class="row mt-3">

        <div class="col-6 mx-auto">

            <form action="/login" method="post">

                <div class="row">

                    <div class="col-12">

                        <label>EMAIL</label>

                    </div>

                </div>

                <div class="row mt-2">

                    <div class="col-12">

                        <input type="email" class="form-control" required placeholder="Email" name="email">

                    </div>

                </div>

                <div class="row mt-3">

                    <div class="col-12">

                        <label>PASSWORD</label>

                    </div>

                </div>

                <div class="row mt-2">

                    <div class="col-12">

                        <input type="password" class="form-control" required placeholder="Password" name="password">

                    </div>

                </div>

                <div class="row mt-3">

                    <div class="col-12">

                        <button class="btn btn-success">SIGN IN</button>

                    </div>

                </div>

            </form>

        </div>

    </div>

</div>

</body>


</html>