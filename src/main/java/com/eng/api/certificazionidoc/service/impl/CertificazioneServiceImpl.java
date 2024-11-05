package com.eng.api.certificazionidoc.service.impl;

import com.eng.api.certificazionidoc.dao.entity.Certificazioni;
import com.eng.api.certificazionidoc.dao.repository.CertificazioniRepository;
import com.eng.api.certificazionidoc.dto.CertificazioneParamsDTO;
import com.eng.api.certificazionidoc.dto.PageMeta;
import com.eng.api.certificazionidoc.dto.PaginatedResponse;
import com.eng.api.certificazionidoc.service.CertificazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class CertificazioneServiceImpl implements CertificazioneService {

    @Autowired
    CertificazioniRepository certificazioniRepository;

    @Override
    public PaginatedResponse<Certificazioni> getAllCertificazioni(CertificazioneParamsDTO paramsDTO) {
        PageRequest pageable;
        if (paramsDTO.getSortType() == null) {
            pageable = PageRequest.of(paramsDTO.getPage() - 1, paramsDTO.getTake());
        } else {
            Sort sort = Sort.by(Sort.Direction.fromString(paramsDTO.getSortType().name()), "dataCertificazione");
            pageable = PageRequest.of(paramsDTO.getPage() - 1, paramsDTO.getTake(), sort);
        }

        Page<Certificazioni> certificazionePage = certificazioniRepository.findAllByStatoAndPeriodo(
                paramsDTO.getFkStatoCertificazione(),
                paramsDTO.getFkPeriodoContablie(),
                pageable);

        PageMeta meta = new PageMeta(
                certificazionePage.getNumber() + 1,
                certificazionePage.getSize(),
                certificazionePage.getTotalElements(),
                certificazionePage.getTotalPages()
        );

        return new PaginatedResponse<>(certificazionePage.getContent(), meta);
    }


}
