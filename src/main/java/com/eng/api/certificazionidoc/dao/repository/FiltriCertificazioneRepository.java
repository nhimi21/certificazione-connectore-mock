package com.eng.api.certificazionidoc.dao.repository;


import com.eng.api.certificazionidoc.dao.entity.FiltriCertificazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FiltriCertificazioneRepository extends JpaRepository<FiltriCertificazione, Integer> {
}
