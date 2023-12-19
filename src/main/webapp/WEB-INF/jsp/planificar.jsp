<!DOCTYPE html>
<html lang="es">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
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
	color: black;
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

#week {
	display: flex;
}

.day {
	height: 160px;
	width: 160px;
	border: 4px solid white;
	background-color: #d2e4d2;
	transition: 0.1s;
	color: white;
	font-size: 36px;
	font-weight: bold;
	display: flex;
	justify-content: center;
	align-items: center;
}

.day:hover {
	transform: scale(0.9);
}

.day-container {
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
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
						<a href="relacionartareas">Relacionar tareas</a>
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
						<a href="/registrarTarea">Añadir tarea</a>
					</button>
				</div>
			</div>
			<div id="view-container">
				<div id="week">
					<div class="day-container">
						<h2>Lunes</h2>
						<div class="day" id="lunes"></div>
					</div>

					<div class="day-container">
						<h2>Martes</h2>
						<div class="day" id="martes"></div>
					</div>

					<div class="day-container">
						<h2>Miércoles</h2>
						<div class="day" id="miercoles"></div>
					</div>

					<div class="day-container">
						<h2>Jueves</h2>
						<div class="day" id="jueves"></div>
					</div>

					<div class="day-container">
						<h2>Viernes</h2>
						<div class="day" id="viernes"></div>
					</div>

					<div class="day-container">
						<h2>Sábado</h2>
						<div class="day" id="sabado"></div>
					</div>

					<div class="day-container">
						<h2>Domingo</h2>
						<div class="day" id="domingo"></div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script>
		// Obtén la fecha actual
		var fechaActual = new Date();

		// Función para llenar los números de los días
		function llenarNumerosDias(fecha) {
			// Días de la semana
			var diasSemana = [ "lunes", "martes", "miercoles", "jueves",
					"viernes", "sabado", "domingo" ];

			// Bucle para recorrer los días y llenar los números
			ultimoDia = new Date(fecha.getFullYear(), fecha.getMonth() + 1, 0)
					.getDate();
			iterador = 1;
			for (var i = 0; i < diasSemana.length; i++) {
				var divDia = document.getElementById(diasSemana[i]);
				// Llena el contenido del div con el número del día actual
				var numeroDia = fecha.getDate() + i - (fecha.getDay() + 6) % 7;
				if (numeroDia > ultimoDia) {
					numeroDia = iterador;
					iterador++;
				}
				var idDia = numeroDia + "-" + fechaActual.getMonth() + "-"
						+ fechaActual.getFullYear();
				divDia.innerHTML = numeroDia;
				divDia.id = idDia;
			}
		}

		// Llena los números de los días al cargar la página
		llenarNumerosDias(fechaActual);
	</script>



</body>

</html>