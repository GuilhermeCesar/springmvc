<%--
  Created by IntelliJ IDEA.
  User: guilherme
  Date: 22/01/19
  Time: 22:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>

<html>
    <head>
        <title>Livros de Java, Android.Iphone</title>

        <c:url value="/resources/css" var="cssPath"/>

        <link rel="stylesheet" href="${cssPath}/bootstrap.min.css">

        <!-- Optional theme -->
        <link rel="stylesheet"
              href="${cssPath}/bootstrap-theme.min.css">

        <style>
            body{
                padding: 60px 0px;
            }
        </style>
    </head>
    <body>
        <div class="container">

            <h1>Login da casa do código</h1>

            <form:form servletRelativeAction="/login" method="POST">
                <div class="form-group">
                    <label>E-mail</label>
                    <input name="username" type="text" class="form-control"/>
                </div>
                <div class="form-group">
                    <label>Senha</label>
                    <input name="password" type="password" class="form-control"/>
                </div>
                <div>
                    <button type="submit" class="btn btn-primary">Logar</button>
                </div>
           </form:form>
        </div>
    </body>
</html>
