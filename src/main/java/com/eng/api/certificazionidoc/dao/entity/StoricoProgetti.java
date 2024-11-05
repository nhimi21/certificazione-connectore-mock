package com.eng.api.certificazionidoc.dao.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@IdClass(StoricoProgettiId.class)
@Table(
        name = "t_storico_progetti"
)
@Entity
public class StoricoProgetti {
    /**
     * JOIN t_certificazioni on id_certificazione = fk_certificazione
     */
    @Id
    @EqualsAndHashCode.Include
    @Column(
            name = "fk_certificazione",
            nullable = false
    )
    private Integer fkCertificazione;

    @Id
    @EqualsAndHashCode.Include
    @Column(
            name = "key_progetto",
            nullable = false
    )
    private String keyProgetto;

    @Column(
            name = "cod_progetto",
            nullable = false
    )
    private String codProgetto;

    @Column(
            name = "key_fonte",
            nullable = false
    )
    private String keyFonte;

    @Column(name = "cod_regionale")
    private String codRegionale;

    @Column(
            name = "titolo_progetto",
            nullable = false
    )
    private String titoloProgetto;

    @Column(
            name = "priorita_progetto",
            nullable = false
    )
    private String prioritaProgetto;

    @Column(
            name = "obiettivo_specifico",
            nullable = false
    )
    private String obiettivoSpecifico;

    @Column(
            name = "azione",
            nullable = false
    )
    private String azione;

    @Column(
            name = "cod_bando",
            nullable = false
    )
    private String codBando;

    @Column(name = "dgr_bando")
    private String dgrBando;

    @Column(name = "de_bando")
    private String deBando;

    @Column(name = "dgr_graduatoria")
    private String dgrGraduatoria;

    @Column(name = "de_localizzazione")
    private String deLocalizzazione;

    @Column(
            name = "imp_costo_previsto",
            nullable = false
    )
    private BigDecimal impCostoPrevisto;

    @Column(
            name = "imp_ammissibile",
            nullable = false
    )
    private BigDecimal impAmmissibile;

    @Column(
            name = "imp_erogabile",
            nullable = false
    )
    private BigDecimal impErogabile;

    @Column(
            name = "imp_presentato",
            nullable = false
    )
    private BigDecimal impPresentato;

    @Column(
            name = "imp_ammesso",
            nullable = false
    )
    private BigDecimal impAmmesso;

    @Column(
            name = "imp_maturato",
            nullable = false
    )
    private BigDecimal impMaturato;

    @Column(
            name = "de_struttura_resp",
            nullable = false
    )
    private String deStrutturaResp;

    @Column(
            name = "cod_tipo_aiuto",
            nullable = false
    )
    private String codTipoAiuto;

    @Column(
            name = "fg_aiuto_parziale",
            nullable = false
    )
    private String fgAiutoParziale;

    @Column(name = "imp_aiuto_concesso")
    private BigDecimal impAiutoConcesso;

    @Column(name = "imp_aiuto_maturato")
    private BigDecimal impAiutoMaturato;

    @Column(name = "codice_cup")
    private String codiceCup;

    @Column(
            name = "imp_anticipo_totale",
            nullable = false
    )
    private BigDecimal impAnticipoTotale;

    @Column(
            name = "imp_quota_abilitante",
            nullable = false
    )
    private BigDecimal impQuotaAbilitante;

    @Column(
            name = "imp_finanz_quota_ue",
            nullable = false
    )
    private BigDecimal impFinanzQuotaUe;

    @Column(
            name = "imp_finanz_quota_stato",
            nullable = false
    )
    private BigDecimal impFinanzQuotaStato;

    @Column(
            name = "imp_finanz_quota_regione",
            nullable = false
    )
    private BigDecimal impFinanzQuotaRegione;

    @Column(
            name = "imp_finanz_quota_altri_pubb",
            nullable = false
    )
    private BigDecimal impFinanzQuotaAltriPubb;

    @Column(
            name = "imp_finanz_quota_privati",
            nullable = false
    )
    private BigDecimal impFinanzQuotaPrivati;

    @Column(name = "fg_assistenza_tecnica")
    private String fgAssistenzaTecnica;

    @Column(name = "imp_strum_finanz_tot")
    private BigDecimal impStrumFinanzTot;

    @Column(name = "imp_strum_finanz_pubb")
    private BigDecimal impStrumFinanzPubb;

    @Column(name = "fg_campionato")
    private String fgCampionato;

    @Column(name = "de_beneficiario")
    private String deBeneficiario;

    @Column(name = "cf_beneficiario")
    private String cfBeneficiario;

    @Column(name = "fg_cert_intermedie")
    private String fgCertIntermedia;

    @Column(name = "fg_cert_anticipi ")
    private String fgCertAnticipi;

    @Column(name = "fg_cert_saldi_parziali")
    private String fgCertSaldiParziali;

    @Column(name = "fg_certificabile")
    private String fgCertificabile;
}
