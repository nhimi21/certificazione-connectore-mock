package com.eng.api.certificazionidoc.dao.repository;

import com.eng.api.certificazionidoc.dao.entity.SimulazioneCert;
import com.eng.api.certificazionidoc.dao.entity.SimulazioneCertId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SimulazioneCertRepository extends JpaRepository<SimulazioneCert, SimulazioneCertId> {
}
