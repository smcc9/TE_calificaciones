<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>
        <c:if test="${estudiante.id == 0}" >Nuevo</c:if>
        <c:if test="${estudiante.id != 0}" >Editar</c:if>
        registro
        </h1>
        <form action="Controlador_estudiante" method="post">
            <input type="hidden" name="id" value="${estudiante.id}"/>
        <label>Nombre:</label>
        <input type="text" name="nombre" value="${estudiante.nombre}" />
        <label>Apellidos:</label>
        <input type="text" name="apellidos" value="${estudiante.apellidos}" />
        <label>Correo:</label>
        <input type="text" name="correo" value="${estudiante.correo}" />
        <br>
        <input type="submit" value="Enviar" />
        </form>
    </body>
</html>
