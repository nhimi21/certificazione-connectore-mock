package com.eng.api.certificazionidoc.dao.repository;


import com.eng.api.certificazionidoc.dao.entity.StoricoQuoteRipartizione;
import com.eng.api.certificazionidoc.dao.entity.StoricoQuoteRipartizioneId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoricoQuoteRipartizioneRepository extends JpaRepository<StoricoQuoteRipartizione, StoricoQuoteRipartizioneId> {
}
