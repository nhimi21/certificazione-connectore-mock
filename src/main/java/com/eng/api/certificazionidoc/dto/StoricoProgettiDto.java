package com.eng.api.certificazionidoc.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class StoricoProgettiDto {

    @NotNull(message = "fkCertificazione non può essere null")
    private Integer fkCertificazione;

    @NotNull(message = "keyProgetto non può essere null")
    private String keyProgetto;

    @NotNull(message = "codProgetto non può essere null")
    private String codProgetto;

    @NotNull(message = "keyFonte non può essere null")
    private String keyFonte;

    private String codRegionale;

    @NotNull(message = "titoloProgetto non può essere null")
    private String titoloProgetto;

    @NotNull(message = "prioritaProgetto non può essere null")
    private String prioritaProgetto;

    @NotNull(message = "obiettivoSpecifico non può essere null")
    private String obiettivoSpecifico;

    @NotNull(message = "azione non può essere null")
    private String azione;

    @NotNull(message = "codBando non può essere null")
    private String codBando;

    private String dgrBando;
    private String deBando;
    private String dgrGraduatoria;
    private String deLocalizzazione;

    @NotNull(message = "impCostoPrevisto non può essere null")
    private BigDecimal impCostoPrevisto;

    @NotNull(message = "impAmmissibile non può essere null")
    private BigDecimal impAmmissibile;

    @NotNull(message = "impErogabile non può essere null")
    private BigDecimal impErogabile;

    @NotNull(message = "impPresentato non può essere null")
    private BigDecimal impPresentato;

    @NotNull(message = "impAmmesso non può essere null")
    private BigDecimal impAmmesso;

    @NotNull(message = "impMaturato non può essere null")
    private BigDecimal impMaturato;

    @NotNull(message = "deStrutturaResp non può essere null")
    private String deStrutturaResp;

    @NotNull(message = "codTipoAiuto non può essere null")
    private String codTipoAiuto;

    @NotNull(message = "fgAiutoParziale non può essere null")
    private String fgAiutoParziale;

    private BigDecimal impAiutoConcesso;
    private BigDecimal impAiutoMaturato;
    private String codiceCup;

    @NotNull(message = "impAnticipoTotale non può essere null")
    private BigDecimal impAnticipoTotale;

    @NotNull(message = "impQuotaAbilitante non può essere null")
    private BigDecimal impQuotaAbilitante;

    @NotNull(message = "impFinanzQuotaUe non può essere null")
    private BigDecimal impFinanzQuotaUe;

    @NotNull(message = "impFinanzQuotaStato non può essere null")
    private BigDecimal impFinanzQuotaStato;

    @NotNull(message = "impFinanzQuotaRegione non può essere null")
    private BigDecimal impFinanzQuotaRegione;

    @NotNull(message = "impFinanzQuotaAltriPubb non può essere null")
    private BigDecimal impFinanzQuotaAltriPubb;

    @NotNull(message = "impFinanzQuotaPrivati non può essere null")
    private BigDecimal impFinanzQuotaPrivati;
    private String fgAssistenzaTecnica;
    private BigDecimal impStrumFinanzTot;
    private BigDecimal impStrumFinanzPubb;
}
