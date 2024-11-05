package com.eng.api.certificazionidoc.dao.repository;


import com.eng.api.certificazionidoc.dao.entity.CodPeriodiContabili;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Repository
public interface CodPeriodiContabiliRepository extends JpaRepository<CodPeriodiContabili, Integer> {
	
	@Query("select p from CodPeriodiContabili p where p.dataInizio<=:date and p.dataFine>=:date")
	Optional<CodPeriodiContabili> getPeriodoByDate(@Param("date") Date date);

	
	@Query("select p from CodPeriodiContabili p where "
			+ " ( p.dataFine>=:d0 and p.dataFine<=:d1 ) or "
			+ " ( p.dataInizio<=:d0 and p.dataInizio<=:d1 ) or "
			+ " ( p.dataInizio<=:d0 and p.dataFine>=:d0 ) or  "
			+ " ( p.dataInizio<=:d1 and p.dataFine>=:d1 ) ")
	List<CodPeriodiContabili> getPeriodiInRange(@Param("d0") Date d0, @Param("d1") Date d1);
	
	List<CodPeriodiContabili> findByCodPeriodoContabile(String codPeriodoContabile);
}
