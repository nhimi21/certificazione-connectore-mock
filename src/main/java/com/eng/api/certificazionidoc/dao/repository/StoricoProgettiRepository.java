package com.eng.api.certificazionidoc.dao.repository;



import com.eng.api.certificazionidoc.dao.entity.StoricoProgetti;
import com.eng.api.certificazionidoc.dao.entity.StoricoProgettiId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoricoProgettiRepository extends JpaRepository<StoricoProgetti, StoricoProgettiId> {
}
