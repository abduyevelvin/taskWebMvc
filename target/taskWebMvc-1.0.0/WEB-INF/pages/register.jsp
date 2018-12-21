<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 11/15/2018
  Time: 12:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Course | Log in</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.7 -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bower_components/bootstrap/dist/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bower_components/font-awesome/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bower_components/Ionicons/css/ionicons.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/dist/css/AdminLTE.min.css">
    <!-- iCheck -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/plugins/iCheck/square/blue.css">

    <!-- Google Font -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
</head>
<div class="register-box">
    <div class="register-logo">
        <b>Register</b>LTE
    </div>

    <div class="register-box-body">
        <p class="login-box-msg">Register a new membership</p>

        <form action="${pageContext.request.contextPath}/register" method="post" id="fileUploadForm" enctype="multipart/form-data">
            <div class="form-group has-feedback">
                <input type="text" class="form-control" placeholder="UserName" id="username" name="username" required>
                <span class="glyphicon glyphicon-user form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <input type="password" class="form-control" placeholder="Password" name="password" id="pass" required>
                <span class="glyphicon glyphicon-lock form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <input type="password" class="form-control" placeholder="Retype password" id="retypePass" required>
                <span class="glyphicon glyphicon-log-in form-control-feedback"></span>
            </div>
            <p id="passMsg"></p>
            <div class="form-group has-feedback">
                <input type="text" class="form-control" placeholder="First Name" name="name" required>
                <span class="glyphicon glyphicon-user form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <input type="text" class="form-control" placeholder="Last Name" name="surname">
                <span class="glyphicon glyphicon-user form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <select class="form-control" name="gender">
                    <option value="0">Choose Gender</option>
                    <option value="male">Male</option>
                    <option value="female">Female</option>
                </select>
            </div>
            <div class="form-group has-feedback">
                <input id="pickUpFileAttachment" type="file" name="attachFileObj" class="form-control" placeholder="Upload Image">
                <span class="glyphicon glyphicon-picture form-control-feedback"></span>
                <span id="fileUploadErr">Please Upload A File!</span>
            </div>
            <div class="row">
                <div class="col-xs-6">
                    <button type="reset" class="btn btn-danger btn-block btn-flat">Clear</button>
                </div>
                <!-- /.col -->
                <div class="col-xs-6">
                    <button type="submit" id="register" class="btn btn-primary btn-block btn-flat">Register</button>
                </div>
            </div>
        </form>

        <div class="social-auth-links text-center">
            <p>- OR -</p>
            <a href="#" class="btn btn-block btn-social btn-facebook btn-flat"><i class="fa fa-facebook"></i> Sign up using
                Facebook</a>
            <a href="#" class="btn btn-block btn-social btn-google btn-flat"><i class="fa fa-google-plus"></i> Sign up using
                Google+</a>
        </div>

        <a href="http://localhost:8083/task/" class="text-center">I already have a membership</a>
    </div>
    <!-- /.form-box -->
</div>

<!-- jQuery 3 -->
<script src="${pageContext.request.contextPath}/resources/bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="${pageContext.request.contextPath}/resources/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- iCheck -->
<script src="${pageContext.request.contextPath}/resources/plugins/iCheck/icheck.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/employee.js"></script>
<script>
    $(function () {
        $('input').iCheck({
            checkboxClass: 'icheckbox_square-blue',
            radioClass: 'iradio_square-blue',
            increaseArea: '20%' // optional
        });

        $('#username').focusout(function () {
            var username = $('#username').val();
            checkUser(username);
        });

        $('#retypePass').keyup(function () {
            var pass = $('#pass').val();
            var retype = $('#retypePass').val();
            if(pass != retype) {
                $('#passMsg').css("color", "red");
                $('#passMsg').text('passwords are not matching!');
            }
            else {
                $('#passMsg').css("color", "green");
                $('#passMsg').text('passwords are matching');
            }
        });

        $("#fileUploadErr").hide();
        // Hide The Error Message When The Attachment Btn Is Clicked.
        $('#pickUpFileAttachment').click(function(eObj) {
            $("#fileUploadErr").hide();
        });
        // Validating Whether The Attachment Is Uploaded Or Not.
        $('#register').click(function(eObj) {
            var file = $("#pickUpFileAttachment").map(function() {
                return $(this).val().trim() ? true : false;
            }).get();
            if (file.includes(true)) {
                // Do Nothing...!
            } else {
                $("#fileUploadErr").css({'color':'red', 'font-weight': 'bold'}).show();
                eObj.preventDefault();
            }
        });
    });
</script>
</body>
</html>
