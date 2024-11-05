package com.eng.api.certificazionidoc.dao.repository;


import com.eng.api.certificazionidoc.dao.entity.StoricoControlli;
import com.eng.api.certificazionidoc.dao.entity.StoricoControlliId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoricoControlliRepository extends JpaRepository<StoricoControlli, StoricoControlliId> {
}
