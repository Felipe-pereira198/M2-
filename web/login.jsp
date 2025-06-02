<%-- 
    Document   : login
    Created on : 27 de mai. de 2025, 21:03:06
    Author     : alunocmc
--%>
<%@ page import="dao.user_dao" %>
<%@ page import="model.usuario" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mygamelist - Login</title>
    </head>
    <body>
        
        <h1>Login</h1>
        
           <%
            String login = request.getParameter("login");
            String senha = request.getParameter("senha");
            
            //ControleUsuario ctrlUsu = new ControleUsuario();
            
            //if (ctrlUsu.logar(login, senha)){
            if (login.equals("pedrinho@gmail.com") && (senha.equals("senha123"))){
                session.setAttribute("autoriza", "1");           
        %>
                <script> window.location.href='index_menu.jsp'; </script>
        <%
            }else{
                session.setAttribute("autoriza", "0"); 
                out.println("Acesso não autorizado!!!");
            }                       
        %>
    </body>
</html>
