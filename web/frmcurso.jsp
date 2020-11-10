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
        <c:if test="${curso.id == 0}" >Nuevo</c:if>
        <c:if test="${curso.id != 0}" >Editar</c:if>
        registro
        </h1>
        <form action="Controlador_curso" method="post">
            <input type="hidden" name="id" value="${curso.id}"/>
        <label>Descripcion:</label>
        <input type="text" name="descripcion" value="${curso.descripcion}" />               
        <br>
        <input type="submit" value="Enviar" />
        </form>
    </body>
</html>
