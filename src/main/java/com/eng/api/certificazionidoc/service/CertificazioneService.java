package com.eng.api.certificazionidoc.service;

import com.eng.api.certificazionidoc.dao.entity.Certificazioni;
import com.eng.api.certificazionidoc.dto.CertificazioneParamsDTO;
import com.eng.api.certificazionidoc.dto.PaginatedResponse;

import java.util.List;

public interface CertificazioneService {
    PaginatedResponse<Certificazioni> getAllCertificazioni(CertificazioneParamsDTO paramsDTO);
}
