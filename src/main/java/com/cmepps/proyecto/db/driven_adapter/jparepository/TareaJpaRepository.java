package com.cmepps.proyecto.db.driven_adapter.jparepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cmepps.proyecto.db.driven_adapter.domain.*;


@Repository
public interface TareaJpaRepository extends JpaRepository<TareaBD, Integer>{
	@Query("select t from Tarea t where t.name = ?1")
	List<TareaBD> findByName(String name);
	List<TareaBD> findAll();
	@Query("select t from Tarea t where t.id = ?1")
	TareaBD findById(int id);
	TareaBD save(TareaBD t);
	void delete(TareaBD t);
	@Modifying
	@Query("update Tarea set name = ?2, description = ?3, hours = ?4, priority = ?5 where id = ?1")
	void update(int id, String name, String description, int hours, int priority);
	@Modifying
	@Query("update Tarea set next = ?2 where id = ?1")
	void setNext(int id, int idnext);
	@Modifying
	@Query("update Tarea set previous = ?2 where id = ?1")
	void setPrevious(int id, int idprevious);
	@Modifying
	@Query("update Tarea set dia = ?2 where id = ?1")
	void updateDia(int id, DiaBD day);
}
