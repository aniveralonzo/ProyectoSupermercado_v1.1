<%-- 
    Document   : crear
    Created on : 18/06/2020, 21:42:57
    Author     : user hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Aniver_website</title>
    </head>
    <body bgcolor="silver">
        <h1>Crear producto</h1>
        <form action="productos" method="post">
        <td><input type="hidden" name="opcion" value="guardar"></td>                
            <table border="1">
                <tr>
                    <td>Nombre:</td>
                    <td><input type="text" name="nombre" size="50"></td>                
                </tr>
                <tr>
                    <td>Cantidad:</td>
                    <td><input type="text" name="cantidad" size="50"></td>                
                </tr>
                <tr>
                    <td>Precio:</td>
                    <td><input type="text" name="precio" size="50"></td>                
                </tr>


            </table>
            <input type="submit" value="Guardar">
            
        </form>
    </body>
</html>
