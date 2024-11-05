package com.eng.api.certificazionidoc.dao.repository;


import com.eng.api.certificazionidoc.dao.entity.StoricoPagamentiAiBenef;
import com.eng.api.certificazionidoc.dao.entity.StoricoPagamentiAiBenefId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoricoPagamentiAiBenefRepository extends JpaRepository<StoricoPagamentiAiBenef, StoricoPagamentiAiBenefId> {
}
