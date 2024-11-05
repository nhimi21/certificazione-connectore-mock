package com.eng.api.certificazionidoc.dto;

import com.eng.api.certificazionidoc.enums.SortType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CertificazioneParamsDTO {
    @Min(1)
    private int page;
    @Min(5)
    @Max(50)
    private int take;
    private SortType sortType;
    private Integer fkStatoCertificazione;
    private Integer fkPeriodoContablie;
}
