<!DOCTYPE html>
<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<html lang="es">

<head>
<title>Document</title>
<style>
* {
	font-family: system-ui, -apple-system, BlinkMacSystemFont, 'Segoe UI',
		Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue',
		sans-serif;
	color: #212836;
}

body {
	margin: 0 auto;
}

#container {
	height: 100vh;
	width: 100%;
}

header {
	height: 8%;
	background-color: darkseagreen;
}

#main-container {
	height: 92%;
	display: flex;
}

#menu-container {
	width: 20%;
	height: 100%;
	display: flex;
	align-items: center;
	flex-direction: column;
	background-color: #f3f7fa;
}

.menu-button {
	height: 8%;
	width: 90%;
	margin-top: 6%;
	border-radius: 20px;
	background-color: #f3f7fa;
	transition: 0.1s;
	border: 1px solid lightgray;
	display: flex;
	align-items: center;
	justify-content: center;
}

.menu-button p {
	
}

a {
	text-decoration: none;
}

.menu-button:hover {
	box-shadow: 7px 7px 16px #e0e3e6, -7px -7px 16px #ffffff;
	transform: scale(1.05);
}

#add-task-container {
	float: inline-start;
	margin-top: auto;
	margin-bottom: 4%;
	width: 100%;
	display: flex;
	justify-content: center;
}

#add-task-button {
	width: 90%;
	height: 60px;
	background-color: darkseagreen;
	border: none;
	cursor: pointer;
	color: white;
	font-weight: bold;
	border-radius: 100px;
	font-size: 24px;
}

#view-container {
	width: 80%;
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
}

#data-container {
	width: 900px;
	height: 600px;
	display: flex;
	flex-direction: row;
	justify-content: center;
	align-items: center;
}

.item {
	display: flex;
	margin-top: 20px;
}

.item p {
	width: 150px;
}

.item label{
  display: inline-block;
  width: 200px;
}

.item input {
	display: flex;
	justify-content: flex-end;
	border: none;
	border-bottom: 1px solid black;
	width: 600px;
}

.item textarea {
	display: flex;
	justify-content: flex-end;
	width: 600px;
}

#right {
	height: 100%;
	margin-left: 5%;
}

#links {
	height: 70%;
	display: flex;
	align-items: center;
}

#buttons {
	height: 30%;
	display: flex;
	align-items: center;
}

.task-buttons {
	width: 100px;
	height: 40px;
	background-color: darkseagreen;
	border: none;
	cursor: pointer;
	color: white;
	font-weight: bold;
	border-radius: 100px;
	margin-right: 10px;
}
</style>
</head>

<body>
	<div id="container">
		<header></header>
		<div id="main-container">
			<div id="menu-container">
				<div class="menu-button">
					<p>
						<a href="tareas">Lista de tareas</a>
					</p>
				</div>
				<div class="menu-button">
					<p>
						<a href="planificarSemana">Planificar semana</a>
					</p>
				</div>
				<div class="menu-button">
					<p>
						<a href="calendario">Calendario de tareas</a>
					</p>
				</div>
				<div id="add-task-container">
					<button id="add-task-button">
						<a href="registrarTarea">AÒadir tarea</a>
					</button>
				</div>
			</div>
			<div id="view-container">
				<h2>AÒadir nueva tarea</h2>
				<form action="/guardar" method="POST" name="datos" id="datos">
					<div id="data-container">
						<div id="left">
							<div class="item">
								<label for="nombre"> Nombre: </label> 
								<input id="nombre" type="text" name="nombre" value="" required />
							</div>
							<div class="item">
								<label for="descripcion"> DescripciÛn: </label> 
								<input id="descripcion" type="text" name="descripcion" value="" />
							</div>
							<div class="item">
								<label for="horas"> Horas estimadas: </label> 
								<input id="horas" type="number" name="horas" value="" required />
							</div>
							<div class="item">
								<label for="prioridad"> Prioridad: </label> 
								<input id="prioridad" type="number" name="prioridad" value="" required />
							</div>
						</div>
				</form>
				<div id="right">
					<div id="links">
						<a href="">Tareas relacionadasè</a>
					</div>
					<div id="buttons">
						<button type ="submit" class="task-buttons" id="guardar-button">Guardar</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
</body>

</html>