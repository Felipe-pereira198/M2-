<%-- 
    Document   : jogo
    Created on : 2 de jun. de 2025, 16:37:25
    Author     : USER
--%>
<%@page import="dao.desenvolvedora_dao"%>
<%@page import="model.desenvolvedora"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
        desenvolvedora dev = new desenvolvedora();
            dev.setNomedev( request.getParameter("nome") );
            dev.setPais( request.getParameter("pais")  ); 
            //cli.setNasc( new Date() );
                        
            desenvolvedora_dao desenvolvedora = new desenvolvedora_dao();
            
            if (desenvolvedora.inserir(dev)){
                out.println("desenvolvedora inserida com sucesso!");
            }else{
                out.println("desenvolvedora não cadastrada!!!");
            }                      
        %>
        
    </body>
</html>
