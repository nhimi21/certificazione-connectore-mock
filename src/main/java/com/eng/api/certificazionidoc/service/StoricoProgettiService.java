package com.eng.api.certificazionidoc.service;


import com.eng.api.certificazionidoc.dao.entity.StoricoProgetti;
import com.eng.api.certificazionidoc.dao.entity.StoricoProgettiId;
import com.eng.api.certificazionidoc.dto.StoricoProgettiDto;

import java.util.List;

public interface StoricoProgettiService {

    List<StoricoProgetti> findAll() throws Exception;

    void createStoricoProgetti(StoricoProgettiDto storicoProgettiDto);

    void deleteById(StoricoProgettiId id);
}
