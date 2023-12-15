package com.cmepps.proyecto.db.driven_adapter.jparepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cmepps.proyecto.db.driven_adapter.domain.DiaBD;

@Repository
public interface DiaJpaRepository extends JpaRepository<DiaBD, Integer>{
	List<DiaBD> findAll();
	@Query(value = "select d from Dia d where d.id = ?1", nativeQuery = true)
	DiaBD findById(int id);
	DiaBD save(DiaBD dia);
	void delete(DiaBD dia);
}
