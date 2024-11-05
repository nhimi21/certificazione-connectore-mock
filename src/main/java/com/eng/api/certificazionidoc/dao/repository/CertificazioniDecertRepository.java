package com.eng.api.certificazionidoc.dao.repository;


import com.eng.api.certificazionidoc.dao.entity.CertificazioniDecert;
import com.eng.api.certificazionidoc.dao.entity.CertificazioniDecertId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificazioniDecertRepository extends JpaRepository<CertificazioniDecert, CertificazioniDecertId> {
}
