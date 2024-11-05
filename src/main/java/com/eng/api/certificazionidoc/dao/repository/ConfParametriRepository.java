package com.eng.api.certificazionidoc.dao.repository;


import com.eng.api.certificazionidoc.dao.entity.ConfParametri;
import com.eng.api.certificazionidoc.dao.entity.ConfParametriId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfParametriRepository extends JpaRepository<ConfParametri, ConfParametriId> {
}
