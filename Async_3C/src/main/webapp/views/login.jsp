<%--
  Created by IntelliJ IDEA.
  User: Ulises
  Date: 06/08/2021
  Time: 09:55 a. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="${pageContext.request.contextPath}" />
<html lang="es">
<head>
    <title>Login</title>
    <link rel="stylesheet" href="${context}/assets/plugins/bootstrap/css/bootstrap.min.css">
    <link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">
</head>

<body>
<br>
<center> <h1 style="color: #6095ea"> Login Usuarios </h1> </center>
<hr>
<br>
<center>
    <form action="${context}/login" method="POST">
        <div class="col-sm-4">
            <label for="correo" class="">Correo:</label>
            <input type="correo" class="form-control" id="correo" placeholder="aaaa@gmail.com">
            <label for="password" class="">Contraseña:</label>
            <input type="password" class="form-control" id="password" placeholder="*******">
            <br>
            <button type="submit" class="btn btn-success">Iniciar sesión <i class="fas fa-user"></i></button>
        </div>
    </form>
</center>
<script src="${context}/assets/plugins/bootstrap/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
</body>
</html>