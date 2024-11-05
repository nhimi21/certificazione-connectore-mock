package com.eng.api.certificazionidoc.dao.repository;


import com.eng.api.certificazionidoc.dao.entity.CertChecklistAcDomande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertChecklistAcDomandeRepository extends JpaRepository<CertChecklistAcDomande, Integer> {
}
