<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Comprar Crédito</h1>
        <form action="/comprarcredito" method="post">
            Nome Titular: <input name="nomeTitular"><br>
            Numero Cartao: <input name="numeroCartao" type="number"><br>
            Codigo Segurança: <input name="codigoSeguranca" type="number"><br>
            Qtd Crédito: <input name="credito" type="number"><br>
            parcelas:   <select name="parcela">
                            <option value="1">x1</option>
                            <option value="2">x2</option>
                            <option value="3">x3</option>
                            <option value="4">x4</option>
                            <option value="5">x5</option>
                            <option value="6">x6</option>
                        </select>
            
            <br>
            <button>Comprar</button>
        </form>
    </body>
</html>
