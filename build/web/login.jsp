<!doctype html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  
  <link rel="stylesheet" href="css/bootstrap.min.css">
  
  <title>DataMy</title>
</head>
<body>
<br><br><br><br><br><br><br><br><br>
    
    <!--Título do Datamy --> 
    <div class="container-fluid">
	<div class="row">
		<div class="col-md-4 col-sm-offset-4">
			<h3 class="text-center text-primary">
				DataMy Administrativo
			</h3>
            </div>
        </div>
    </div>
<div id="blocoLogin" class="container">

<!--formulário do login -->
<form action="/logar" method="post">
<!--col-sm-offset-6 deixa o conteúdo na outra div -->    
  <div class="row">
    <div class="col-md-4 col-sm-offset-4">
      <div class="input-group" >
	    <label class="input-group input-group-addon"><b class="glyphicon glyphicon-user"></b></label>
            <input autofocus type="text" class="form-control" id="cmpLogin" placeholder="Login" name="username">
      </div>
	</div>
  </div>
  
  <!--formulário da senha -->    
  <br>
  <div class="row">
    <div class="col-md-4 col-sm-offset-4">
      <div class="input-group">
	    <label class="input-group input-group-addon"><b class="glyphicon glyphicon-log-in"></b></label>
            <input type="password" class="form-control" id="cmpSenha" placeholder="Senha" name="password">
      </div>
	</div>
  </div>
    
  <!--link caso o usuario esqueceu a senha -->
  <div class="row">
	<div class="col-md-4 col-sm-offset-4 text-right">
	  <a href="esqueceu.jsp">Esqueceu sua senha?</a>
	</div>
  </div>
    
    <!--link para cadastrar -->
    <br>
  <div class="row">
	<div class="col-md-4 col-sm-offset-4 text-right">
	  <a href="cadastro.jsp">Cadastre-se</a>
	</div>
  </div>
 
  
  <!--botão de login -->
    <br>
  <div class="row">
    <div class="col-md-4 col-sm-offset-4 text-right">
	  <button class="btn btn-default" id="btnLogin">Login</button>
	</div>
  </div>
</form>
</div>

</body>
</html>
