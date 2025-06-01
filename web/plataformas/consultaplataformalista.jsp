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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Controle de Clientes</title>
        
        <style>
            table {
                border-collapse: collapse;
                width: 100%                    
            }
            th, td{
                padding: 8px;
                text-align: left;
                border: 1px solid #DDD
            }
            tr:hover {background-color: #D6EEEE }
            
        </style>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-SgOJa3DmI69IUzQ2PVdRZhwQ+dy64/BUtbMJw1MZ8t5HZApcHrRKUc4W0kG879m7" crossorigin="anonymous">
    </head>
    <body>
        <h2>MyGameList - Consulta - Lista Geral</h2> <br>
        
        <%           
                                    
            plataforma_dao plataforma_dao = new plataforma_dao();
            
            List<plataforma> lista = new ArrayList();
            lista = plataforma_dao.consultar_jogos();
            
            out.println("<br><h3> Consulta jogos - Lista geral </h3><br>");
        %>    
            <table class="table table-hover" >                
                <tr bgcolor="#F3F3F3">
                   <th><b>#</b></th> 
                   <th><b>Plataforma</b></th> 
                   <th><b>Dono</b></th> 
                </tr>            
        <%    
            for (int i=0; i<=lista.size()-1; i++ ){                
        %>
                <tr>
                    <td>  <%=(i+1)%> </td>
                    <td>  <%=lista.get(i).getNome_plataforma()%> </td>
                    <td>  <%=lista.get(i).getDono()%> </td> 
                    
                </tr>
        <%        
            }
        %>
            </table>
            
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/js/bootstrap.bundle.min.js" integrity="sha384-k6d4wzSIapyDyv1kpU366/PK5hCdSbCRGRCMv+eplOQJWyd1fbcAu9OCUj5zNLiq" crossorigin="anonymous"></script>
    </body>
</html>
