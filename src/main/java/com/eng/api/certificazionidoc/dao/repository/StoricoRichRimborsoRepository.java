package com.eng.api.certificazionidoc.dao.repository;

import com.eng.api.certificazionidoc.dao.entity.StoricoRichRimborso;
import com.eng.api.certificazionidoc.dao.entity.StoricoRichRimborsoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoricoRichRimborsoRepository extends JpaRepository<StoricoRichRimborso, StoricoRichRimborsoId> {
}
