<%@page import="java.util.List"%>
<%@page import="com.cmepps.proyecto.core.domain.*"%>
<!DOCTYPE html>
<html lang="es">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Selecci�n de tarea</title>
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

a {
	text-decoration: none;
}

.container {
	text-align: center;
}

.tarea {
	background-color: darkcyan;
	width: 40rem;
	margin-left: auto;
	margin-right: auto;
	display: flex;
	margin-bottom: 1rem;
	border-radius: 1rem;
}

.datos {
	text-align: left;
	width: 30rem;
	margin-left: 3rem;
	color: white;
}

.botones {
	text-align: right;
	display: flex;
	justify-content: center;
	align-items: center;
	flex-direction: column;
}

#seleccionarButton {
	margin-bottom: 1rem;
	border: none;
	cursor: pointer;
	color: white;
	font-weight: bold;
	border-radius: 100px;
	background-color: darkseagreen;
	width: 100px;
	height: 40px;
}


#tareas-scroll {
	overflow-y: auto;
}

* {
	font-family: system-ui, -apple-system, BlinkMacSystemFont, "Segoe UI",
		Roboto, Oxygen, Ubuntu, Cantarell, "Open Sans", "Helvetica Neue",
		sans-serif;
}
</style>
</head>

<body>
	<%
		int idDia = Integer.parseInt(request.getAttribute("dia").toString());
	%>
	<div id="container">
		<header></header>
		<div id="main-container">
			<div id="menu-container">
				<div class="menu-button">
					<p>
						<a href="/tareas">Lista de tareas</a>
					</p>
				</div>
				<div class="menu-button">
					<p>
						<a href="/planificarSemana">Planificar semana</a>
					</p>
				</div>
				<div class="menu-button">
					<p>
						<a href="/calendario">Calendario de tareas</a>
					</p>
				</div>
				<div id="add-task-container">
					<button id="add-task-button">
						<a href="/registrarTarea">A�adir tarea</a>
					</button>
				</div>
			</div>
			<div id="view-container">
				<h1>Selecciona una tarea</h1>
				<div id="tareas-scroll">
					<% List<Tarea> tareas = (List<Tarea>) request.getAttribute("tareas");
							if(tareas != null){
									for(Tarea t : tareas){
										out.println("<div class=\"tarea\">");
										out.println("<div class=\"datos\">");
										out.println("<h2>"+t.getNombre()+"</h2>");
										out.println("<p>"+t.getDescripcion()+"</p>");
										out.println("<p>"+"Horas estimadas: "+t.getHoras()+"</p>");
										out.println("<p>"+"Prioridad: "+t.getPrioridad()+"</p>");
										out.println("</div>");
										out.println("<div class=\"botones\">");
										out.println("<form action=\"/asignarDia\" method=\"POST\" name=\"datos\" id=\"datos\">");
										out.println("<input type=\"hidden\" value=" + idDia + " id=\"iddia\" name=\"iddia\" />");
										out.println("<input type=\"hidden\" value=" + t.getId() + " id=\"idtarea\" name=\"idtarea\" />");
										out.println("<button type=\"submit\" id=\"seleccionarButton\">Seleccionar</button>");
										out.println("</form>");
										out.println("</div>");
										out.println("</div>");
									}
							}
					%>
				</div>
			</div>
		</div>
	</div>

</body>

</html>