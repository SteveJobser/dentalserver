package kz.tlegenov.dentalserver.Repositories;


import kz.tlegenov.dentalserver.Models.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RecordRepository extends JpaRepository<Record, Long> {
	@Query(value="SELECT d FROM Record d WHERE "
			+ "d.dateTime >= :beginDate "
			+ "AND d.dateTime <= :endDate "
			+ "AND d.status = :status "
			+ "ORDER BY d.dateTime")
	public List<Record> getRecordsForPeriod(@Param("beginDate") String beginDate, @Param("endDate") String endDate, @Param("status") int status);
	
}
