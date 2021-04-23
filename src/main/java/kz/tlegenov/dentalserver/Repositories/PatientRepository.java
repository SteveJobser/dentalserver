package kz.tlegenov.dentalserver.Repositories;


import kz.tlegenov.dentalserver.Models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
	
	@Query(value = "SELECT p FROM Patient p WHERE p.name LIKE '%' || :keyword || '%'"
			+ " OR p.lastName LIKE '%' || :keyword || '%'"
			+ " OR p.patroNymic LIKE '%' || :keyword || '%'"
			+ " OR p.address LIKE '%' || :keyword || '%'")
	public List<Patient> search(@Param("keyword") String keyword);
	
	
	@Query(value="SELECT * FROM patient ORDER BY id DESC LIMIT 10", nativeQuery = true)
	public List<Patient> getLastTenPatient();
}