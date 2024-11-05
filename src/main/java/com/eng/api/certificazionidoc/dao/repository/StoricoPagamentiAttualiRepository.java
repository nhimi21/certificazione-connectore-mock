package com.eng.api.certificazionidoc.dao.repository;


import com.eng.api.certificazionidoc.dao.entity.StoricoPagamentiAttuali;
import com.eng.api.certificazionidoc.dao.entity.StoricoPagamentiAttualiId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoricoPagamentiAttualiRepository extends JpaRepository<StoricoPagamentiAttuali, StoricoPagamentiAttualiId> {
}
