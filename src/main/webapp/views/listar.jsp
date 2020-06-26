<%-- 
    Document   : listar
    Created on : 18/06/2020, 21:43:25
    Author     : user hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Aniver_website</title>
    </head>
    <body bgcolor="silver">
        <h1>Lista de productos</h1>
        <table border="1">
            <tr>
                <td>ID  </td>
                <td>Nombre  </td>                
                <td>Cantidad  </td>
                <td>Precio  </td>
                <td>Fecha Creacion  </td>
                <td>Fecha Actualizacion  </td>
                <td>Opcion  </td>
            </tr>
            <c:forEach var="producto" items="${lista}">
            <tr>
                <td> <a href="productos?opcion=meditar&id=<c:out value="${ producto.id}"></c:out>"><c:out value="${ producto.id}"></c:out>  </a> </td>
                <td><c:out value="${producto.nombre}"></c:out></td>                
                <td><c:out value="${producto.cantidad}"></c:out></td>
                <td><c:out value="${producto.precio}"></c:out></td>
                <td><c:out value="${producto.fechaCrear}"></c:out></td>
                <td><c:out value="${producto.fechaActualizar}"></c:out></td>
                <td> <a href="productos?opcion=eliminar&id=<c:out value="${ producto.id}"></c:out>">Eliminar </a> </td>
            </tr>                
            </c:forEach>                        
        </table>        
    </body>
</html>
