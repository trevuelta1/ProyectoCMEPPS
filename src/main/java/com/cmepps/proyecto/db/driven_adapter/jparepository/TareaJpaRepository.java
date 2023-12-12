package com.cmepps.proyecto.db.driven_adapter.jparepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cmepps.proyecto.db.driven_adapter.domain.TareaBD;

public interface TareaJpaRepository extends JpaRepository<TareaBD, Integer>{
	List<TareaBD> findByName(String name);
}
