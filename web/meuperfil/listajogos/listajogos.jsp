<!DOCTYPE html>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.desenvolvedora"%>
<%@page import="dao.jogo_dao"%>
<%@page import="model.jogo"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.*"%>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>MyGameList - Lista de Jogos</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body {
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            font-family: Arial, sans-serif;
        }

        .tables {
            display: flex;
            flex-direction: column;
            align-items: center;
            color: #000;
            padding: 20px;
        }

        h1 {
            color: white;
            margin-bottom: 20px;
        }

        .btn-edit {
            background-color: #198754;
            color: white;
            padding: 4px 8px;
            font-size: 0.8rem;
            border-radius: 4px;
        }

        .btn-delete {
            background-color: #dc3545;
            color: white;
            padding: 4px 8px;
            font-size: 0.8rem;
            border-radius: 4px;
        }

        .btn-edit:hover,
        .btn-delete:hover {
            opacity: 0.9;
        }

        .btn-group {
            display: flex;
            gap: 6px;
            justify-content: center;
        }
    </style>
</head>
<body>

    <div class="tables">
        <h1>Lista de Jogos</h1>
    </div>
 <%           
                                    
            jogo_dao jogo = new jogo_dao();
            
            List<jogo> lista = new ArrayList();
            lista = jogo.consultar_lista_simples(); // certo

            
            out.println("<br><h3> Consulta cliente Lista geral </h3><br>");
        %>    

    <div class="tables">
        <table class="table table-striped table-hover table-bordered">
            <thead class="table-dark">
                <tr>
                    <th>Codigo</th>
                    <th>Nome do Jogo</th>
                    <th>Descrição</th>
                    <th>Data de Lançamento</th>
                    <th>Gênero</th>
                    <th>Desenvolvedora</th>
                    <th>ações</th>
                </tr> <%    
            for (int i=0; i<=lista.size()-1; i++ ){                
        %>
            </thead>
            <tbody>
                <tr>
                    <td><%=(i+1)%></td>
                    <td><%= lista.get(i).getNome_jogo()%></td>
                    <td> <%=lista.get(i).getDescricao()%></td>
                    <td><%=lista.get(i).getGenero()%></td>
                    <td><%=new SimpleDateFormat("dd/MM/yyyy").format(lista.get(i).getDt_lancamento())%></td>
                    <td><%=lista.get(i).getNome_desenvolvedora()%></td>
                    <td>
                        <div class="btn-group">
                            <button class="btn btn-edit">Editar</button>
                            <button class="btn btn-delete">Excluir</button>
                        </div>
                    </td>
                </tr>
                <%        
            }
        %>
                <!-- Adicione mais jogos aqui -->
            </tbody>
        </table>
    </div>

</body>
</html>