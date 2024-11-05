package com.eng.api.certificazionidoc.dao.repository;


import com.eng.api.certificazionidoc.dao.entity.StoricoDecertificazioni;
import com.eng.api.certificazionidoc.dao.entity.StoricoDecertificazioniId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoricoDecertificazioniRepository extends JpaRepository<StoricoDecertificazioni, StoricoDecertificazioniId> {
}
