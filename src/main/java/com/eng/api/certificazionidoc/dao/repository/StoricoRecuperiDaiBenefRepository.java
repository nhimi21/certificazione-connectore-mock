package com.eng.api.certificazionidoc.dao.repository;

import com.eng.api.certificazionidoc.dao.entity.StoricoRecuperiDaiBenef;
import com.eng.api.certificazionidoc.dao.entity.StoricoRecuperiDaiBenefId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoricoRecuperiDaiBenefRepository extends JpaRepository<StoricoRecuperiDaiBenef, StoricoRecuperiDaiBenefId> {
}
