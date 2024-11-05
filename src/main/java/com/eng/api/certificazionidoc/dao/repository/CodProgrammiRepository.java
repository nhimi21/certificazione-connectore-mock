package com.eng.api.certificazionidoc.dao.repository;


import com.eng.api.certificazionidoc.dao.entity.CodProgrammi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
;import java.util.Optional;

@Repository
public interface CodProgrammiRepository extends JpaRepository<CodProgrammi, Integer> {
	Optional<CodProgrammi> findByCodProgramma(String codProgramma);
}
