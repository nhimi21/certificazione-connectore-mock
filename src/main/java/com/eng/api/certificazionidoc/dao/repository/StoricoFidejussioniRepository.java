package com.eng.api.certificazionidoc.dao.repository;


import com.eng.api.certificazionidoc.dao.entity.StoricoFidejussioni;
import com.eng.api.certificazionidoc.dao.entity.StoricoFidejussioniId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoricoFidejussioniRepository extends JpaRepository<StoricoFidejussioni, StoricoFidejussioniId> {
}
