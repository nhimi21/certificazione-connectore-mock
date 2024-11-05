package com.eng.api.certificazionidoc.dao.repository;


import com.eng.api.certificazionidoc.dao.entity.CodStatiCertificazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CodStatiCertificazioneRepository extends JpaRepository<CodStatiCertificazione, Integer> {
}
