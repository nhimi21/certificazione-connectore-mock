package com.eng.api.certificazionidoc.service.impl;

import com.eng.api.certificazionidoc.dao.entity.CodProgrammi;
import com.eng.api.certificazionidoc.dao.repository.CodProgrammiRepository;
import com.eng.api.certificazionidoc.enums.ErrorCode;
import com.eng.api.certificazionidoc.exception.CertificazioniException;
import com.eng.api.certificazionidoc.service.ProgrammaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgrammaServiceImpl implements ProgrammaService {

    @Autowired
    private CodProgrammiRepository codProgrammiRepository;

    @Override
    public List<CodProgrammi> getAllCodProgrammi() {
        return codProgrammiRepository.findAll();
    }

    @Override
    public CodProgrammi getCodProgramma(Integer idProgramma) throws CertificazioniException {
        CodProgrammi codProgrammi = codProgrammiRepository.findById(idProgramma).orElse(null);

        if (codProgrammi == null) {
            throw new CertificazioniException(ErrorCode.INTERNAL_SERVER_ERROR, "Impossibile trovare il cod programma");
        }
        return codProgrammi;
    }
}
