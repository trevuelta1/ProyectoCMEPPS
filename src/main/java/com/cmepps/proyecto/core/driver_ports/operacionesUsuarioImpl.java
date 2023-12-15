package com.cmepps.proyecto.core.driver_ports;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cmepps.proyecto.core.domain.*;
import com.cmepps.proyecto.core.driven_ports.*;
import com.cmepps.proyecto.db.driven_adapter.domain.*;

public class operacionesUsuarioImpl implements operacionesUsuario {

	private operacionesBD funcionesBD;

	public operacionesUsuarioImpl(operacionesBD funcionesBD) {
		this.funcionesBD = funcionesBD;
	}

	public List<Tarea> listaTareas() {
		List<Tarea> tareas = new ArrayList<Tarea>();
		List<TareaBD> tareasBD = funcionesBD.listarTareas();
		for (int i = 0; i < tareasBD.size(); i++) {
			Tarea t = new Tarea(tareasBD.get(i).getId(), tareasBD.get(i).getName(), tareasBD.get(i).getDescription(),
					tareasBD.get(i).getHours(), tareasBD.get(i).getPriority());
			if (tareasBD.get(i).getDia() != null) {
				t.setDia(tareasBD.get(i).getDia().getId());
			}
			tareas.add(t);
		}
		return tareas;
	}

	public List<Tarea> buscarTarea(String nombre) {
		List<Tarea> tareas = new ArrayList<Tarea>();
		List<TareaBD> tareasBD = funcionesBD.buscarTareaPorNombre(nombre);
		for (int i = 0; i < tareasBD.size(); i++) {
			Tarea t = new Tarea(tareasBD.get(i).getId(), tareasBD.get(i).getName(), tareasBD.get(i).getDescription(),
					tareasBD.get(i).getHours(), tareasBD.get(i).getPriority());
			if (tareasBD.get(i).getDia() != null) {
				t.setDia(tareasBD.get(i).getDia().getId());
			}
			tareas.add(t);
		}
		return tareas;
	}

	public List<Dia> listaDias() {
		List<Dia> dias = new ArrayList<Dia>();
		List<DiaBD> diasBD = funcionesBD.listarDias();
		for (int i = 0; i < diasBD.size(); i++) {
			List<Tarea> tareas = new ArrayList<Tarea>();
			for (int j = 0; j < diasBD.get(i).getTareas().size(); j++) {
				Tarea t = new Tarea(diasBD.get(i).getTareas().get(j).getId(),
						diasBD.get(i).getTareas().get(j).getName(), diasBD.get(i).getTareas().get(j).getDescription(),
						diasBD.get(i).getTareas().get(j).getHours(), diasBD.get(i).getTareas().get(j).getPriority());
				t.setDia(diasBD.get(i).getId());
				tareas.add(t);
			}
			Dia d = new Dia(diasBD.get(i).getId(), tareas);
			dias.add(d);
		}
		return dias;
	}

	public Dia buscarDia(int id) {
		Dia dia;
		DiaBD diaBD = funcionesBD.buscarDiaPorId(id);
		List<Tarea> tareas = new ArrayList<Tarea>();
		for (int j = 0; j < diaBD.getTareas().size(); j++) {
			Tarea t = new Tarea(diaBD.getTareas().get(j).getId(), diaBD.getTareas().get(j).getName(),
					diaBD.getTareas().get(j).getDescription(), diaBD.getTareas().get(j).getHours(),
					diaBD.getTareas().get(j).getPriority());
			t.setDia(diaBD.getId());
			tareas.add(t);
		}
		dia = new Dia(diaBD.getId(), tareas);
		return dia;
	}
	
	public Tarea guardaTarea(Tarea t) {
		TareaBD guardar = new TareaBD(t.getNombre(), t.getDescripcion(), t.getHoras(), t.getPrioridad());
		funcionesBD.guardarTarea(guardar);
		TareaBD tareabd = funcionesBD.buscarTareaPorId(guardar.getId());
		Tarea tarea = new Tarea(tareabd.getId(), tareabd.getName(), tareabd.getDescription(), tareabd.getHours(), tareabd.getPriority());
		return tarea;
	}
	
	public void eliminaTarea(Tarea t) {
		TareaBD eliminar = funcionesBD.buscarTareaPorId(t.getId());
		funcionesBD.eliminarTarea(eliminar);
	}
	
	public void modificaTarea(Tarea t) {
		TareaBD modificar = funcionesBD.buscarTareaPorId(t.getId());
		funcionesBD.modificarTarea(modificar.getId(), t.getNombre(), t.getDescripcion(), t.getHoras(), t.getPrioridad());
	}
	
	public void asignaTareaSucesora(Tarea t, Tarea sucesora) {
		TareaBD actual = funcionesBD.buscarTareaPorId(t.getId());
		TareaBD siguiente = funcionesBD.buscarTareaPorId(sucesora.getId());
		funcionesBD.asignarSucesora(actual.getId(), siguiente.getId());
	}
	
	public void asignaTareaAntecesora(Tarea t, Tarea antecesora) {
		TareaBD actual = funcionesBD.buscarTareaPorId(t.getId());
		TareaBD anterior = funcionesBD.buscarTareaPorId(antecesora.getId());
		funcionesBD.asignarAntecesora(actual.getId(), anterior.getId());
	}
	
	public void asignaDia(Tarea t, Dia d) {
		TareaBD tarea = funcionesBD.buscarTareaPorId(t.getId());
		DiaBD dia = funcionesBD.buscarDiaPorId(d.getId());
		funcionesBD.asignarDia(tarea.getId(), dia);
	}
}
