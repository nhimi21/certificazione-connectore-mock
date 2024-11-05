package com.eng.api.certificazionidoc.service.impl;

import com.eng.api.certificazionidoc.dao.entity.StoricoProgetti;
import com.eng.api.certificazionidoc.dao.entity.StoricoProgettiId;
import com.eng.api.certificazionidoc.dao.repository.StoricoProgettiRepository;
import com.eng.api.certificazionidoc.dto.StoricoProgettiDto;
import com.eng.api.certificazionidoc.service.StoricoProgettiService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StoricoProgettiServiceImpl implements StoricoProgettiService {

    @Autowired
    private StoricoProgettiRepository repositoryStoricoProgetti;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<StoricoProgetti> findAll() throws Exception {
        List<StoricoProgetti> progetti = repositoryStoricoProgetti.findAll();
        if (progetti.isEmpty()) {
            throw new Exception("No StoricoProgetti found.");
        }
        return progetti;
    }

    @Override
    public void createStoricoProgetti(StoricoProgettiDto storicoProgettiDto) {
        StoricoProgetti storicoProgetti1 = modelMapper.map(storicoProgettiDto, StoricoProgetti.class);
        repositoryStoricoProgetti.save(storicoProgetti1);
    }

    @Override
    public void deleteById(StoricoProgettiId id) {
        boolean exist = repositoryStoricoProgetti.existsById(id);
        if (!exist) {
            throw new RuntimeException("StoricoProgetti with id " + id + " does not exist.");
        } else {
            repositoryStoricoProgetti.deleteById(id);
        }
    }
}
