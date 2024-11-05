package com.eng.api.certificazionidoc.dao.repository;

import com.eng.api.certificazionidoc.dao.entity.SospensioniAc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SospensioniAcRepository extends JpaRepository<SospensioniAc, Integer> {
}
