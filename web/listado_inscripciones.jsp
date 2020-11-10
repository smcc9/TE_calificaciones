<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado</title>
    </head>
    <body>
        <h1>Listado de Inscripciones</h1>
        <p><a href="Controlador_inscripcion?action=add">Nuevo registro</a></p>
        <table border="1">
            <tr>
                <th>Id</th>
                <th>Curso</th>
                <th>Estudiante</th>
                <th>Nota Final</th>
                <th></th>
                <th></th>
            </tr>
            <c:forEach var="item" items="${inscripcion}">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.descripcion}</td>
                    <td>${item.nombre}</td>
                    <td>${item.nota_final}</td>
                <td><a href="Controlador_inscripcion?action=edit&id=${item.id}">Editar</a></td>
                <td><a href="Controlador_inscripcion?action=delete&id=${item.id}">Eliminar</a></td>
                <tr>
            </c:forEach>

        </table>       
    </body>
</html>
