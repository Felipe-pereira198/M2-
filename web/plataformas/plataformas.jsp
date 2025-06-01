<%-- 
    Document   : plataformas
    Created on : 31 de mai. de 2025, 18:42:48
    Author     : pedro
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="dao.plataforma_dao"%>
<%@page import="model.plataforma"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.*"%>
<!DOCTYPE html>
<html>
    <head>
        <title>MyGameList - Plataformas</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
    </head>
    <body>
        <div>
            <h1>Plataformas</h1>
            <table class="table table-hover">
                <tr>
                    <th>#</th><th>Plataforma</th><th>Dono</th></tr>
                    <% for (int i = 0; i < lista.size(); i++) { %>
                <tr>
                    <td><%= (i + 1) %></td>
                    <td><%= lista.get(i).getNome_plataforma() %></td>
                    <td><%= lista.get(i).getDono() %></td>
                </tr>
                <% } %>
            </table>
        </div>
    </body>
</html>
