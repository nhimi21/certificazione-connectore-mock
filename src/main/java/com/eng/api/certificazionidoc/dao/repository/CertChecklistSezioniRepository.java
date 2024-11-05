package com.eng.api.certificazionidoc.dao.repository;


import com.eng.api.certificazionidoc.dao.entity.CertChecklistSezioni;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertChecklistSezioniRepository extends JpaRepository<CertChecklistSezioni, Integer> {
}
