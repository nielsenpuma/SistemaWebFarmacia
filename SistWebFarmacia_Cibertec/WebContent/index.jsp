<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%
	String mensaje = "";
	if(request.getAttribute("msg")!=null){
		mensaje = (String) request.getAttribute("msg");
	}
%>

<!DOCTYPE>
<html lang="ES">
<head>
<%@ include file="meta.jsp"%>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/extras.css">
<link rel="icon" type="image/png" href="img/icon.png" />
<title>Acceso</title>
</head>
<body>
	<!--Header-->
	<%@ include file="header.jsp"%>
	<!--Container-->
	<div class="container">
		<div class="jumbotron">
			<form class="login-form form-signin" action="ServletEmpleado?tipo=sesion" method="post">
				<h2 class="form-signin-heading text-center">
					<img id="login-icon" src="img/color/users-2.svg">
				</h2>
				<br>
				<div class="input-group">
					<span class="input-group-addon" id="sizing-addon2"><img
						src="img/icon/account-login.svg"></span> <input type="text"
						class="form-control" placeholder="Usuario" aria-label="Usuario"
						aria-describedby="sizing-addon2" name="txtuser" autofocus>
				</div>
				<br>
				<div class="input-group">
					<span class="input-group-addon" id="sizing-addon2"><img
						src="img/icon/lock-locked.svg"></span> <input type="password"
						class="form-control" placeholder="Contraseña"
						aria-label="Contraseña" aria-describedby="sizing-addon2" name="txtpass">
				</div>
				<br>
				<button class="btn btn-lg btn-success btn-block" type="submit">Iniciar</button>
			</form>
			<div class="alert alert-danger"><%=mensaje%></div>
		</div>
	</div>
	<script src="js/jquery-3.2.1.slim.min.js"></script>
	<script src="js/popper.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/efectos.js"></script>
</body>
</html>