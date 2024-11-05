package com.eng.api.certificazionidoc.dao.repository;


import com.eng.api.certificazionidoc.dao.entity.Certificazioni;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificazioniRepository extends JpaRepository<Certificazioni, Integer> {

    @Query("select c from Certificazioni c where " +
            "(:fkStatoCertificazione is null or c.codStatiCertificazione.idStatoCert=:fkStatoCertificazione) " +
            "and (:fkPeriodoContablie is null or c.codPeriodiContabili.idPeriodoContabile=:fkPeriodoContablie)")
    Page<Certificazioni> findAllByStatoAndPeriodo(Integer fkStatoCertificazione, Integer fkPeriodoContablie, Pageable pageable);
}
