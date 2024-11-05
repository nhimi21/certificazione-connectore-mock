package com.eng.api.certificazionidoc.dao.repository;


import com.eng.api.certificazionidoc.dao.entity.ProgettiCertificati;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgettiCertificatiRepository extends JpaRepository<ProgettiCertificati, String> {
}
