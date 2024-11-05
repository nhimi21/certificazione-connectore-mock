package com.eng.api.certificazionidoc.dao.repository;


import com.eng.api.certificazionidoc.dao.entity.CodOrigineDecertificazioni;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CodOrigineDecertificazioniRepository extends JpaRepository<CodOrigineDecertificazioni, Integer> {
}
