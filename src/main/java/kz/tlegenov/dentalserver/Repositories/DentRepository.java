package kz.tlegenov.dentalserver.Repositories;

import kz.tlegenov.dentalserver.Models.Dent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DentRepository extends JpaRepository<Dent, Long> {
	
}
