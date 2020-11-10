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
            <c:if test="${inscripcion.id == 0}">Nuevo</c:if>
            <c:if test="${inscripcion.id != 0}">Editar</c:if>            
        registro
        </h1>
        <form action="Controlador_inscripcion" method="post">
        <input type="hidden" name="id" value="${inscripcion.id}"/>
        <label>Estudiante:</label>
        <input type="text" name="id_estudiante" value="${inscripcion.nombre}" />
        <select name="id_estudiante">
            <option></option>
        </select>
        <label>Curso</label>
        <input type="text" name="id_curso" value="${inscripcion.descripcion}" />        
        <label>Nota:</label>
        <input type="text" name="nota_final" value="${inscripcion.nota_final}" />
        <br>
        <input type="submit" value="Enviar" />
        </form>
    </body>
</html>
