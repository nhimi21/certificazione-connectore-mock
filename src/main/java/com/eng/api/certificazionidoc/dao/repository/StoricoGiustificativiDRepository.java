package com.eng.api.certificazionidoc.dao.repository;


import com.eng.api.certificazionidoc.dao.entity.StoricoGiustificativiD;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoricoGiustificativiDRepository extends JpaRepository<StoricoGiustificativiD, Integer> {
}
