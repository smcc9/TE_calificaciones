<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Listado de Curso</h1>
        <p><a href="Controlador_curso?action=add">Nuevo registro</a></p>
        <table border="1">
            <tr>
                <th>Id</th>
                <th>Descripcion</th>                
                <th></th>
                <th></th>
            </tr>
            <c:forEach var="item" items="${curso}" >
                <tr>
                <td>${item.id}</td>
                <td>${item.descripcion}</td>
                <td><a href="Controlador_curso?action=edit&id=${item.id}">Editar</a></td>
                <td><a href="Controlador_curso?action=delete&id=${item.id}">Eliminar</a></td>
                </tr>                
            </c:forEach>
        </table>       
    </body>
</html>
