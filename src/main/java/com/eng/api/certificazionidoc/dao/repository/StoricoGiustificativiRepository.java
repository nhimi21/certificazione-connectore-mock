package com.eng.api.certificazionidoc.dao.repository;

import com.eng.api.certificazionidoc.dao.entity.StoricoGiustificativi;
import com.eng.api.certificazionidoc.dao.entity.StoricoGiustificativiId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoricoGiustificativiRepository extends JpaRepository<StoricoGiustificativi, StoricoGiustificativiId> {
}
