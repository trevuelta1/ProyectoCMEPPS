package com.cmepps.proyecto.core.driver_ports;
import java.util.ArrayList;
import java.util.List;

import com.cmepps.proyecto.core.domain.*;
import com.cmepps.proyecto.core.driven_ports.*;
import com.cmepps.proyecto.db.driven_adapter.domain.*;


public class operacionesUsuarioImpl implements operacionesUsuario{
	private operacionesBD funcionesBD = new operacionesBDImpl();
	public List<Tarea> listaTareas(){
		List<Tarea> tareas = new ArrayList<Tarea>();
		List<TareaBD> tareasBD = funcionesBD.listarTareas();
		for(int i = 0; i < tareasBD.size(); i++) {
			Tarea t = new Tarea(tareasBD.get(i).getId(), tareasBD.get(i).getName(), tareasBD.get(i).getDescription(), tareasBD.get(i).getHours(), tareasBD.get(i).getPriority());
			if(tareasBD.get(i).getDia() != null) {
				t.setDia(tareasBD.get(i).getDia().getId());
			}
			tareas.add(t);
		}
		return tareas;
	}
	public List<Tarea> buscarTarea(String nombre){
		List<Tarea> tareas = new ArrayList<Tarea>();
		List<TareaBD> tareasBD = funcionesBD.buscarTareaPorNombre(nombre);
		for(int i = 0; i < tareasBD.size(); i++) {
			Tarea t = new Tarea(tareasBD.get(i).getId(), tareasBD.get(i).getName(), tareasBD.get(i).getDescription(), tareasBD.get(i).getHours(), tareasBD.get(i).getPriority());
			if(tareasBD.get(i).getDia() != null) {
				t.setDia(tareasBD.get(i).getDia().getId());
			}
			tareas.add(t);
		}
		return tareas;
	}
	public List<Dia> listaDias(){
		List<Dia> dias = new ArrayList<Dia>();
		List<DiaBD> diasBD = funcionesBD.listarDias();
		for(int i = 0; i < diasBD.size(); i++) {
			List<Tarea> tareas = new ArrayList<Tarea>();
			for(int j = 0; j < diasBD.get(i).getTareas().size(); j++) {
				Tarea t = new Tarea(diasBD.get(i).getTareas().get(j).getId(), diasBD.get(i).getTareas().get(j).getName(), diasBD.get(i).getTareas().get(j).getDescription(), diasBD.get(i).getTareas().get(j).getHours(), diasBD.get(i).getTareas().get(j).getPriority());
				t.setDia(diasBD.get(i).getId());
				tareas.add(t);
			}
			Dia d = new Dia(diasBD.get(i).getId(), tareas);
			dias.add(d);
		}
		return dias;
	}
	public List<Dia> buscarDia(int id){
		List<Dia> dias = new ArrayList<Dia>();
		List<DiaBD> diasBD = funcionesBD.buscarDiaPorId(id);
		for(int i = 0; i < diasBD.size(); i++) {
			List<Tarea> tareas = new ArrayList<Tarea>();
			for(int j = 0; j < diasBD.get(i).getTareas().size(); j++) {
				Tarea t = new Tarea(diasBD.get(i).getTareas().get(j).getId(), diasBD.get(i).getTareas().get(j).getName(), diasBD.get(i).getTareas().get(j).getDescription(), diasBD.get(i).getTareas().get(j).getHours(), diasBD.get(i).getTareas().get(j).getPriority());
				t.setDia(diasBD.get(i).getId());
				tareas.add(t);
			}
			Dia d = new Dia(diasBD.get(i).getId(), tareas);
			dias.add(d);
		}
		return dias;
	}
}
