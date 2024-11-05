package com.eng.api.certificazionidoc.dao.repository;


import com.eng.api.certificazionidoc.dao.entity.ConfChecklistAc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfChecklistAcRepository extends JpaRepository<ConfChecklistAc, Integer> {
}
