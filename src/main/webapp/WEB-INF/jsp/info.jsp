<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Información</title>
    </head>
    <body>
        <p>
            <%
                String mensaje = (String) request.getAttribute("mensaje");
                out.println(mensaje);
            %>  
        </p>
    </body>
</html>