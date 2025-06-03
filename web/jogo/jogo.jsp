<%-- 
    Document   : jogo
    Created on : 2 de jun. de 2025, 16:37:25
    Author     : USER
--%>


<%@page import="dao.desenvolvedora_dao"%>
<%@page import="model.desenvolvedora"%>
<%@page import="java.util.List"%>
<%@page import="dao.jogo_dao"%>
<%@page import="model.jogo"%>
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
    out.println("<h3>Valores recebidos do formulário:</h3>");
    out.println("Nome: " + request.getParameter("nome") + "<br>");
    out.println("Descrição: " + request.getParameter("descricao") + "<br>");
    out.println("Gênero: " + request.getParameter("genero") + "<br>");
    out.println("Lançamento: " + request.getParameter("lancamento") + "<br>");
    out.println("Desenvolvedora (ID): " + request.getParameter("dev") + "<br><br>");
%>

        <%
        jogo jogo = new jogo();
            jogo.setNome_jogo( request.getParameter("nome") );
            jogo.setDescricao( request.getParameter("descricao")  ); 
            jogo.setGenero(request.getParameter("genero"));
            jogo.setDt_lancamento( new SimpleDateFormat("yyyy-MM-dd").parse( request.getParameter("lancamento") ) );
            jogo.setId_desenvolvedora(Integer.parseInt(request.getParameter("dev")));
            //cli.setNasc( new Date() );
                        
            jogo_dao jogodao = new jogo_dao();
            
            if (jogodao.inserir(jogo)){
                out.println("jogo inserido com sucesso!");
            }else{
                out.println("jogo não cadastrado!!!");
            }                      
        %>
        
    </body>
</html>
