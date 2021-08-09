<%--
  Created by IntelliJ IDEA.
  User: Ulises
  Date: 06/08/2021
  Time: 08:24 a. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="context" value="${pageContext.request.contextPath}" />
<html>
<head>
    <title>Listado Juegos</title>
    <link rel="stylesheet" href="${context}/assets/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${context}/assets/dist/css/styles.css">
    <link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">
</head>
<body>
    <div class="modal fade" id="details" tabindex="-1" aria-labelledby="exampleModalLabel2" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title" style="color: #6095ea">Detalles de Games</h1>
                    <button type="button" class="btn btn-close" data-bs-dismiss="modal" aria-label="Cerrar"></button>
                </div>
                <div class="modal-body">
                    <br>
                    <h3><i class="fas fa-fingerprint"></i>Id del Juego:</h3>
                    <label id="lbl_idGames"></label>
                    <h3><i class="fas fa-ghost"></i>Nombre del juego:</h3>
                    <label id="lbl_name"></label>
                    <h3><i class="fas fa-image"></i>Imagen Juego:</h3>
                    <img src="data:image/jpeg;base64,${ game.imgGame }">
                    <h3><i class="far fa-calendar-alt"></i>Fecha premier:</h3>
                    <label id="lbl_datePremiere"></label>
                    <h3><i class="fas fa-certificate"></i>Id de la categoria del juego:</h3>
                    <label id="lbl_Category_idCategory"></label>
                    <h3><i class="fas fa-info-circle"></i>Status del juego:</h3>
                    <label id="lbl_status"></label>
                </div>
            </div>
        </div>
    </div>
    <script src="${context}/assets/plugins/bootstrap/js/bootstrap.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
    <script src="${context}/assets/dist/js/main.js"> </script>
</body>
</html>
