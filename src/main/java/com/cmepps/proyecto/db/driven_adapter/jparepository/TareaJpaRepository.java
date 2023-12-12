package com.cmepps.proyecto.db.driven_adapter.jparepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cmepps.proyecto.db.driven_adapter.domain.TareaBD;

@Repository
public interface TareaJpaRepository extends JpaRepository<TareaBD, Integer>{
	@Query("select t from Tarea t where t.name = ?1")
	List<TareaBD> findByName(String name);
	List<TareaBD> findAll();
	@Query("select t from Tarea t where t.id = ?1")
	List<TareaBD> findById(int id);
}
