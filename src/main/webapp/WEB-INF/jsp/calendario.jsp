<%@page import="java.util.List"%>
<%@page import="com.cmepps.proyecto.core.domain.*"%>
<!DOCTYPE html>
<html lang="es">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Ver calendario</title>
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

.normal-day {
	height: 100px;
	width: 120px;
	text-align: center;
	background-color: #d2e4d2;
	color: white;
	font-size: 24px;
	font-weight: bold;
	cursor: pointer;
	transition: 0.1s;
}

.normal-day:hover {
	transform: scale(0.9);
}

/*.outOfMonth-day {
    height: 100px;
    width: 120px;
    text-align: center;
    background-color: rgba(143, 188, 143, 0.2);
}*/
.current-day {
	background-color: #a5c9a5;
	font-size: 36px;
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
						<a href="/registrarTarea">A�adir tarea</a>
					</button>
				</div>
			</div>
			<%
				List<Dia> dias = (List<Dia>)request.getAttribute("diasCreados");
			%>
			<div id="view-container">
				<table id="calendar">
					<caption></caption>
					<thead>
						<tr>
							<th>Dom</th>
							<th>Lun</th>
							<th>Mar</th>
							<th>Mie</th>
							<th>Jue</th>
							<th>Vie</th>
							<th>Sab</th>
						</tr>
					</thead>
					<tbody></tbody>
				</table>
			</div>
		</div>
	</div>

	<script>
    document.addEventListener('DOMContentLoaded', function () {
      const calendar = document.getElementById('calendar');
      const tbody = calendar.querySelector('tbody');
      const caption = calendar.querySelector('caption');

      function generateCalendar(year, month) {
        const firstDay = new Date(year, month, 1);
        const lastDay = new Date(year, month + 1, 0);
        const daysInMonth = lastDay.getDate();
        const startingDay = firstDay.getDay();

        tbody.innerHTML = '';

        caption.textContent = new Intl.DateTimeFormat('es', { month: 'long', year: 'numeric' }).format(firstDay);

        let day = 1;

        for (let i = 0; i < 6; i++) {
          const row = document.createElement('tr');

          for (let j = 0; j < 7; j++) {
            if (i === 0 && j < startingDay) {
              const emptyCell = document.createElement('td');
              row.appendChild(emptyCell);
            } else if (day <= daysInMonth) {
              const cell = document.createElement('td');
              cell.textContent = day;

              // Asignar clases según si el día está en el mes actual
              if (month === new Date().getMonth() && year === new Date().getFullYear()) {
                cell.classList.add('normal-day');
              } else {
                cell.classList.add('outOfMonth-day');
              }

              // Añadir la clase 'current-day' si es el día actual
              if (day === new Date().getDate() && month === new Date().getMonth() && year === new Date().getFullYear()) {
                cell.classList.add('current-day');
              }

              row.appendChild(cell);
              day++;
            }
          }

          tbody.appendChild(row);

          if (day > daysInMonth) {
            break;
          }
        }
      }

      const currentDate = new Date();
      generateCalendar(currentDate.getFullYear(), currentDate.getMonth());
    });
  </script>

</body>

</html>