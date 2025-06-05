<!DOCTYPE html>
<html lang="pt-BR">
<%@ page import="dao.lista_jogo_dao" %>
<%@ page import="model.listajogo" %>
<%@ page import="java.util.List" %>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>MyGameList - Jogos</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: 'Segoe UI', Arial, sans-serif; /* Fonte moderna */
        }
        
        body {
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            padding: 20px;
        }

        .form-container {
            width: 100%;
            max-width: 400px;
            padding: 30px;
            background: white;
            border-radius: 10px;
            box-shadow: 0 5px 15px rgba(0, 0, 0, 0.1);
        }

        .form-title {
            font-size: 24px;
            font-weight: 600;
            color: #333;
            text-align: center;
            margin-bottom: 20px;
        }

        .input-group {
            margin-bottom: 20px;
            position: relative;
        }


        .input-label {
            display: block;
            font-size: 14px;
            font-weight: 500;
            color: #555;
            margin-bottom: 8px;
        }

        .form-input {
            width: 100%;
            padding: 12px 15px;
            font-size: 16px;
            border: 2px solid #ddd;
            border-radius: 6px;
            transition: border-color 0.3s;
        }

        .form-input:focus {
            border-color: #667eea;
            outline: none;
        }

        .form-button {
            width: 100%;
            padding: 14px;
            font-size: 16px;
            font-weight: 600;
            color: white;
            background: linear-gradient(to right, #667eea, #764ba2);
            border: none;
            border-radius: 6px;
            cursor: pointer;
            transition: opacity 0.3s;
        }

        .form-button:hover {
            opacity: 0.9;
        }

        /* --- Texto de Rodapé --- */
        .form-footer {
            text-align: center;
            margin-top: 20px;
            font-size: 14px;
            color: #666;
        }

        .form-footer a {
            color: #667eea;
            text-decoration: none;
            font-weight: 500;
        }

    </style>
</head>
<body>

    <div class="form-container">
        <h1 class="form-title">Avaliação</h1>

        <form method="post" action="jogo.jsp">
            <div class="input-group">
                <label for="nome_jogo" class="input-label">Progresso </label>
                <input name="nome" type="text" id="nome" class="form-input" placeholder="Digite seu nome" required>
            </div>

            <div class="input-group">
                <label for="email" class="input-label">Nota</label>
                <input type="text" name="descricao" id="text" class="form-input" required>
            </div>

            <div class="input-group">
                <label for="nascimento" class="input-label">Data inicio</label>
                <input type="date" name="lancamento" id="lancamento" class="form-input" required>
            </div>
            <div class="input-group">
                <label for="Genero" class="input-label">Data Fim</label>
                <input type="text" name="genero" id="lancamento" class="form-input" >
            </div>
             <div class="input-group">
                  <label for="dev" class="input-label">Status</label>
    <select name="dev" class="form-input" required>
        <option value="">Selecione</option>
        <option value="start">começei</option>
        <option value="end">terminei</option>
        <option value="ongoing">jogando</option>
        <option value="drop"> dropei </option>
    </select>
            </div>
            <button type="submit" class="form-button">Enviar</button>
        </form>

    </div>
</body>
</html>
