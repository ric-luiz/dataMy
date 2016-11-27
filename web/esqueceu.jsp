<!doctype html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  
  <link rel="stylesheet" href="css/bootstrap.min.css">
  
  <title>DataMy</title>
</head>
<body>
    
    <script>
        function validar() {
            
          var usuario = document.getElementById('cmpLogin').value;
            
        if(usuario==0){
           window.alert("Dados não informados!"); 
        }else{   
          window.alert("Mensagem enviada com sucesso!");
        }

        }
    
    </script>

<br><br><br><br><br><br><br><br><br>
    
    <!--Título do Datamy --> 
    <div class="container-fluid">
	<div class="row">
		<div class="col-md-4 col-sm-offset-4">
			<h3 class="text-center text-primary">
				DataMy Recuperação de Senha
			</h3>
            <h5 class="text-center text-primary">
				Digite seu email para recuperar sua senha.
			</h5>
            </div>
        </div>
    </div>
<div id="blocoLogin" class="container">

<!--formulário do login -->
<form action="/esqueceu">
<!--col-sm-offset-6 deixa o conteúdo na outra div -->    
  <div class="row">
    <div class="col-md-4 col-sm-offset-4">
      <div class="input-group" >
	    <label class="input-group input-group-addon"><b class="glyphicon glyphicon-user"></b></label>
	    <input autofocus type="text" class="form-control" id="cmpLogin" placeholder="Email">
      </div>
	</div>
  </div>
  <!--botão de login -->
    <br>
  <div class="row">
    <div class="col-md-4 col-sm-offset-4 text-right">
	  <button class="btn btn-default" onclick="validar()" id="btnLogin">Enviar</button>
	</div>
  </div>
</form>
</div>

</body>
</html>