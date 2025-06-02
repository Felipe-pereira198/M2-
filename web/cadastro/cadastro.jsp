<%-- 
    Document   : cadastro
    Created on : 1 de jun. de 2025, 18:36:07
    Author     : USER
--%>
<%@page import="dao.user_dao"%>
<%@page import="model.usuario"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.*"%>
<%@page import="dao.user_dao"%>
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
            usuario user = new usuario(); // Instância do obj
            // Atrib. valor
            user.setNome( request.getParameter("nome") );
            user.setEmail( request.getParameter("email")  ); 
            user.setSenha(request.getParameter("senha"));          
            user.setDt_nasc( new SimpleDateFormat("yyyy-MM-dd").parse( request.getParameter("nascimento") ) );
            //cli.setNasc( new Date() );
                        
            user_dao userdao = new user_dao();
            
            if (userdao.inserir(user)){
                out.println("Cliente inserido com sucesso!");
            }else{
                out.println("Cliente não cadastrado!!!");
            }                      
        %>
    </body>
</html>
