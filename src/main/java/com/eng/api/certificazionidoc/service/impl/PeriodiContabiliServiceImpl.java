package com.eng.api.certificazionidoc.service.impl;

import com.eng.api.certificazionidoc.dao.entity.CodPeriodiContabili;
import com.eng.api.certificazionidoc.dao.repository.CodPeriodiContabiliRepository;
import com.eng.api.certificazionidoc.exception.CertificazioniException;
import com.eng.api.certificazionidoc.service.PeriodiContabiliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PeriodiContabiliServiceImpl implements PeriodiContabiliService {

	@Autowired
	CodPeriodiContabiliRepository codPeriodiContabiliRepository;

	@Override
	public CodPeriodiContabili addNewPeriodo(CodPeriodiContabili newPeriodo) throws CertificazioniException {
		checkUniqueCode(newPeriodo);
		checkDateSequence(newPeriodo);
		checkOverlap(newPeriodo);

		return codPeriodiContabiliRepository.save(newPeriodo);
	}

	@Override
	public CodPeriodiContabili updatePeriodo(CodPeriodiContabili newPeriodo) throws CertificazioniException {
		checkDateSequence(newPeriodo);
		checkOverlap(newPeriodo);
		checkUniqueCode(newPeriodo);
		return codPeriodiContabiliRepository.save(newPeriodo);
	}

	@Override
	public List<CodPeriodiContabili> findAll() {
		return codPeriodiContabiliRepository.findAll();
	}

	private void checkUniqueCode(CodPeriodiContabili newPeriodo) throws CertificazioniException {
		List<CodPeriodiContabili> items = codPeriodiContabiliRepository
				.findByCodPeriodoContabile(newPeriodo.getCodPeriodoContabile());
		items = exclude(items, newPeriodo);
		if (!items.isEmpty()) {
			throw CertificazioniException.ERR_PERIODO_CODEEXISTS;
		}
	}

	private void checkOverlap(CodPeriodiContabili newPeriodo) throws CertificazioniException {
		Date dataInizio = newPeriodo.getDataInizio();
		Date dataFine = newPeriodo.getDataFine();
		List<CodPeriodiContabili> periodiInRange = codPeriodiContabiliRepository.getPeriodiInRange(dataInizio,
				dataFine);
		periodiInRange = exclude(periodiInRange, newPeriodo);
		if (!periodiInRange.isEmpty()) {
			throw CertificazioniException.ERR_PERIODO_OVERLAP;
		}
	}

	private void checkDateSequence(CodPeriodiContabili newPeriodo) throws CertificazioniException {
		Date dataInizio = newPeriodo.getDataInizio();
		Date dataFine = newPeriodo.getDataFine();
		boolean ok = dataInizio.before(dataFine);
		if (!ok) {
			throw CertificazioniException.ERR_PERIODO_WRONGSEQ;
		}
	}

	private List<CodPeriodiContabili> exclude(List<CodPeriodiContabili> pcs, CodPeriodiContabili excluded) {
		if (excluded.getIdPeriodoContabile() == null) {
			return pcs;
		}
		return pcs.stream()
				.filter(it -> ! it.getIdPeriodoContabile().equals(excluded.getIdPeriodoContabile()))
				.collect(Collectors.toList());
	}

}
