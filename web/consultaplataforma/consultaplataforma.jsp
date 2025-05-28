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
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-SgOJa3DmI69IUzQ2PVdRZhwQ+dy64/BUtbMJw1MZ8t5HZApcHrRKUc4W0kG879m7" crossorigin="anonymous">        
    </head>
    <body>
        <h1>MyGameList - Consulta de Plataforma/Dono</h1>
        
        <%
            String pkParam = request.getParameter("pk_plataforma");
            if (pkParam != null && !pkParam.isEmpty()) {
                try {
                    int pk = Integer.parseInt(pkParam);
                    plataforma plataforma = new plataforma();
                    plataforma.setPk_plataforma(pk);

                    plataforma_dao plataforma_dao = new plataforma_dao();
                    plataforma platEncontrada = plataforma_dao.consultar_id(plataforma);

                    if (platEncontrada != null) {
                        out.println("<br><b>Plataforma:</b> " + platEncontrada.getNome_plataforma());
                        out.println("<br><b>Dono:</b> " + platEncontrada.getDono());
                    } else {
                        out.println("Plataforma não localizada.");
                        //<a type="button" href="http://localhost:8080/WebAppjogo/consultaplataforma/">Voltar</a>
                    }
                } catch (NumberFormatException e) {
                    out.println("ID inválido.");
                    //<a type="button" href="http://localhost:8080/WebAppjogo/consultaplataforma/">Voltar</a>
                }
            } else {
                out.println("Parâmetro 'pk_plataforma' não informado.");
                //<a type="button" href="http://localhost:8080/WebAppjogo/consultaplataforma/">Voltar</a>
            }
        %>
        <div>
            <a type="button" href="http://localhost:8080/WebAppjogo/consultaplataforma/">Voltar</a>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/js/bootstrap.bundle.min.js" integrity="sha384-k6d4wzSIapyDyv1kpU366/PK5hCdSbCRGRCMv+eplOQJWyd1fbcAu9OCUj5zNLiq" crossorigin="anonymous"></script>       
    </body>
</html>
