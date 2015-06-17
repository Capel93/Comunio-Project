<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
  <title></title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"/>
</head>
<body>
<div class="container">
  <div class="row">
    <div class="col-md-6 col-md-offset-3">
      <div class="panel panel-login">
        <div class="panel-heading">
          <div class="row">
            <div class="col-xs-6">
              <a href="/login" id="login-form-link">Login</a>
            </div>
            <div class="col-xs-6">
              <a href="/register" class="active" id="register-form-link">Register</a>
            </div>
          </div>
          <hr>
        </div>
        <div class="panel-body">
          <div class="row">
            <div class="col-lg-12">

              <form:form id="register-form" action="/register" method="post" role="form" style="display: block;" modelAttribute="user">
                <div class="form-group">
                  <form:input path="username" type="text" name="username" id="username" tabindex="1" class="form-control" placeholder="Username" value=""></form:input>
                </div>
                <div class="form-group">
                  <form:input path="email" type="email" name="email" id="email" tabindex="1" class="form-control" placeholder="Email Address" value=""></form:input>
                </div>
                <div class="form-group">
                  <form:input path="teamSquad" type="teamSquad" name="teamSquad" id="teamSquad" tabindex="1" class="form-control" placeholder="Team Squad Name" value=""></form:input>
                </div>
                <div class="form-group">
                  <form:input path="password" type="password" name="password" id="password" tabindex="2" class="form-control" placeholder="Password"></form:input>
                </div>
                <div class="form-group">
                  <input type="password" name="confirm-password" id="confirm-password" tabindex="2" class="form-control" placeholder="Confirm Password">
                </div>
                <div class="form-group">
                  <div class="row">
                    <div class="col-sm-6 col-sm-offset-3">
                      <input type="submit" name="register-submit" id="register-submit" tabindex="4" class="form-control btn btn-register" value="Register Now">
                    </div>
                  </div>
                </div>
              </form:form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
</body>
</html>

