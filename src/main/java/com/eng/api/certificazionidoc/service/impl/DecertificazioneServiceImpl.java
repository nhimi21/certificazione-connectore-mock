package com.eng.api.certificazionidoc.service.impl;

import com.eng.api.certificazionidoc.dao.entity.CertificazioniDecert;
import com.eng.api.certificazionidoc.dao.repository.CertificazioniDecertRepository;
import com.eng.api.certificazionidoc.service.DecertificazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DecertificazioneServiceImpl implements DecertificazioneService {

    @Autowired
    CertificazioniDecertRepository certificazioniDecertRepository;

    @Override
    public List<CertificazioniDecert> getAllDecertificazione() {
        return certificazioniDecertRepository.findAll();
    }
}
