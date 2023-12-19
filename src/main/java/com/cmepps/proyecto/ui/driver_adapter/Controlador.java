package com.cmepps.proyecto.ui.driver_adapter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.cmepps.proyecto.core.domain.*;
import com.cmepps.proyecto.core.driver_ports.*;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/")
public class Controlador {
	@Autowired
	private operacionesUsuario funcionesUsuario;
	private List<Dia> diasCreados = new ArrayList<Dia>();
	private Calendario calendario = new Calendario();
	@GetMapping("/")
	public String inicio(@RequestParam(value = "name", defaultValue = "World") String name) {
        return "index";
    }
	@GetMapping("/tareas")
	public String listatareas(HttpServletRequest request, HttpServletResponse response) {
        List<Tarea> tareas = funcionesUsuario.listaTareas();
        request.setAttribute("tareas", tareas);
		return "listatareas";
    }
	@PostMapping("/guardar")
	public String guardatareas(HttpServletRequest request, HttpServletResponse response) {
		String nombre, descripcion;
		int horas, prioridad;
		nombre = request.getParameter("nombre");
		descripcion = request.getParameter("descripcion");
		horas = Integer.parseInt(request.getParameter("horas"));
		prioridad = Integer.parseInt(request.getParameter("prioridad"));
		Tarea t = new Tarea(-1, nombre, descripcion, horas, prioridad);
		t = funcionesUsuario.guardaTarea(t);
		request.setAttribute("mensaje", "Tarea agregada correctamente");
		return "info";
	}
	@GetMapping("/registrarTarea")
	public String registrartarea(HttpServletRequest request, HttpServletResponse response) {
		return "nuevatarea";
	}
	@PostMapping("/eliminar")
	public String eliminatareas(HttpServletRequest request, HttpServletResponse response) {
		String nombre, descripcion;
		int id, horas, prioridad;
		id = Integer.parseInt(request.getParameter("id"));
		nombre = request.getParameter("nombre");
		descripcion = request.getParameter("descripcion");
		horas = Integer.parseInt(request.getParameter("horas"));
		prioridad = Integer.parseInt(request.getParameter("prioridad"));
		Tarea t = new Tarea(id, nombre, descripcion, horas, prioridad);
		funcionesUsuario.eliminaTarea(t);
		request.setAttribute("mensaje", "Tarea eliminada correctamente");
		return "info";
	}
	@PostMapping("/modificar")
	public String modificatareas(HttpServletRequest request, HttpServletResponse response) {
		String nombre, descripcion;
		int id, horas, prioridad;
		id = Integer.parseInt(request.getParameter("id"));
		nombre = request.getParameter("nombre");
		descripcion = request.getParameter("descripcion");
		horas = Integer.parseInt(request.getParameter("horas"));
		prioridad = Integer.parseInt(request.getParameter("prioridad"));
		Tarea t = new Tarea(id, nombre, descripcion, horas, prioridad);
		funcionesUsuario.modificaTarea(t);
		request.setAttribute("mensaje", "Tarea modificada correctamente");
		return "info";
	}
	@PostMapping("/asignarDia")
	public String asignadia(HttpServletRequest request, HttpServletResponse response) {
		int dia, mes, año, iddia, idtarea;
		idtarea = Integer.parseInt(request.getParameter("id"));
		dia = Integer.parseInt(request.getParameter("dia"));
		mes = Integer.parseInt(request.getParameter("mes"));
		año = Integer.parseInt(request.getParameter("año"));
		iddia = año + (mes * 10000) + (dia * 1000000);
		Dia d = funcionesUsuario.buscarDia(iddia);
		Tarea t = funcionesUsuario.buscarTareaPorId(idtarea);
		if(d == null) {
			d = new Dia(iddia, new ArrayList<Tarea>());
			funcionesUsuario.asignaDia(t, d);
			funcionesUsuario.guardaDia(d);
			diasCreados.add(d);
		} else {
			funcionesUsuario.asignaDia(t, d);
		}
		request.setAttribute("mensaje", "La tarea ha sido asignada al día indicado.");
		return "info";
	}
	@GetMapping("/calendario")
	public String vercalendario(HttpServletRequest request, HttpServletResponse response) {
		if(request.getAttribute("calendario") != null) {
			calendario = (Calendario) request.getAttribute("calendario");
		}
		request.setAttribute("diasCreados", diasCreados);
		request.setAttribute("calendario", calendario);
		return "calendario";
	}
	@GetMapping("/planificarSemana")
	public String versemana(HttpServletRequest request, HttpServletResponse response) {
		if(request.getAttribute("calendario") != null) {
			calendario = (Calendario) request.getAttribute("calendario");
		}
		request.setAttribute("calendario", calendario);
		List<Tarea> tareas = funcionesUsuario.listaTareas();
        request.setAttribute("tareas", tareas);
		return "planificar";
	}
}
