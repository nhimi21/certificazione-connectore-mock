package com.eng.api.certificazionidoc.dao.repository;


import com.eng.api.certificazionidoc.dao.entity.ConfChecklistAcSezioni;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfChecklistAcSezioniRepository extends JpaRepository<ConfChecklistAcSezioni, Integer> {
}
