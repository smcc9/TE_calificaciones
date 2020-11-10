<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Estudiantes</title>
    </head>
    <body>
        <h1>Listado de Estudiantes</h1>
        <p><a href="Controlador_estudiante?action=add">Nuevo registro</a></p>
        <table border="1">
            <tr>
                <th>Id</th>
                <th>Nombres</th>
                <th>Apellidos</th>
                <th>Correo</th>
                <th></th>
                <th></th>
            </tr>
            <c:forEach var="item" items="${estudiante}" >
                <tr>
                <td>${item.id}</td>
                <td>${item.nombre}</td>
                <td>${item.apellidos}</td>
                <td>${item.correo}</td>
                <td><a href="Controlador_estudiante?action=edit&id=${item.id}">Editar</a></td>
                <td><a href="Controlador_estudiante?action=delete&id=${item.id}">Eliminar</a></td>
                </tr>                
            </c:forEach>
        </table>       
    </body>
</html>
