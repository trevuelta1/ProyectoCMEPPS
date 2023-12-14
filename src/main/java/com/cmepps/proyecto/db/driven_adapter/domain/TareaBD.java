package com.cmepps.proyecto.db.driven_adapter.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "Tarea")
public class TareaBD {
	@Id
	@Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "name", nullable = false, length = 50)
	private String name;
	@Column(name = "description", nullable = true, length = 500)
	private String description;
	@Column(name = "hours", nullable = false)
	private int hours;
	@Column(name = "priority", nullable = false)
	private int priority;
	@Column(name = "next", nullable = true)
	private int next;
	@Column(name = "previous", nullable = true)
	private int previous;
	@ManyToOne(optional = true, cascade = CascadeType.ALL)
	private DiaBD dia;
	
	public TareaBD() {
		super();
	}
	public TareaBD(String name, String description, int hours, int priority) {
		super();
		this.name = name;
		this.description = description;
		this.hours = hours;
		this.priority = priority;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public DiaBD getDia() {
		return dia;
	}
	public void setDia(DiaBD dia) {
		this.dia = dia;
	}
	public int getNext() {
		return next;
	}
	public void setNext(int next) {
		this.next = next;
	}
	public int getPrevious() {
		return previous;
	}
	public void setPrevious(int previous) {
		this.previous = previous;
	}
}
