package com.eng.api.certificazionidoc.service;


import com.eng.api.certificazionidoc.dao.entity.CodPeriodiContabili;
import com.eng.api.certificazionidoc.exception.CertificazioniException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PeriodiContabiliService {

	CodPeriodiContabili addNewPeriodo(CodPeriodiContabili newPeriodo) throws CertificazioniException;

	CodPeriodiContabili updatePeriodo(CodPeriodiContabili newPeriodo) throws CertificazioniException;

	List<CodPeriodiContabili> findAll();
}
