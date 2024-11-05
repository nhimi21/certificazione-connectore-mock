package com.eng.api.certificazionidoc.service;

import com.eng.api.certificazionidoc.dao.entity.CodProgrammi;
import com.eng.api.certificazionidoc.exception.CertificazioniException;

import java.security.cert.CertificateException;
import java.util.List;

public interface ProgrammaService {
    List<CodProgrammi> getAllCodProgrammi();

    CodProgrammi getCodProgramma(Integer idProgramma) throws CertificazioniException;
}
