<%-- 
    Document   : listar
    Created on : 28/09/2015, 05:17:28 PM
    Author     : Dave
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar</title>
    </head>
    <body>
        <h1>${list}</h1>
        
        <c:forEach var="persona" items="${list}">
            ${persona}
        </c:forEach>
        
    <table border="1">    
        <tr style="border: 1px solid black">
            <td>Id</dr><td>Nombre</td><td>Apellido Paterno</td><td>Apellido Materno</td><td>Alias</td><td></td> 
            <td><a href="/myFirstApplication/persona/crear">Agregar</td>
    </tr>
    
    <c:forEach var="persona" items="${list}">
     <tr style="border: 1px solid black">
         <td><a href="/myFirstApplication/persona/mostrar?personaId=${persona.id}">${persona.id}</dr>
        <td>${persona.nombre}</td>
        <td>${persona.apellido_paterno}</td>
        <td>${persona.apellido_materno}</td>
        <td>${persona.alias}</td>
        <td><a href="/myFirstApplication/persona/eliminar?personaId=${persona.id}">Eliminar</td>
        <td><a href="/myFirstApplication/persona/editar?personaId=${persona.id}">Editar</td>
</tr>
        </c:forEach>
    </table>
    </body>
</html>
