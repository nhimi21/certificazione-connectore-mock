package com.eng.api.certificazionidoc.dao.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@IdClass(CertificazioniDetId.class)
@Table(
        name = "t_certificazioni_det"
)
@Entity
public class CertificazioniDet {

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

    /**
     * JOIN t_progetti_certificati on key_progetto = key_progetto
     */
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
            name = "cod_priorita",
            nullable = false
    )
    private String codPriorita;

    @Column(
            name = "cod_obiettivo",
            nullable = false
    )
    private String codobiettivo;

    @Column(
            name = "cod_azione",
            nullable = false
    )
    private String codAzione;

    @Column(
            name = "imp_certificabile",
            nullable = false
    )
    private BigDecimal impCertificabile;

    @Column(
            name = "imp_certificato_adg",
            nullable = false
    )
    private BigDecimal impCertificatoAdg;

    @Column(
            name = "imp_ue_adg",
            nullable = false
    )
    private BigDecimal impUeAdg;

    @Column(
            name = "imp_stato_adg",
            nullable = false
    )
    private BigDecimal impStatoAdg;

    @Column(
            name = "imp_regione_adg",
            nullable = false
    )
    private BigDecimal impRegioneAdg;

    @Column(
            name = "imp_certificato_ac",
            nullable = false
    )
    private BigDecimal impCertificatoAc;

    @Column(
            name = "imp_ue_ac",
            nullable = false
    )
    private BigDecimal impUeAc;

    @Column(
            name = "imp_stato_ac",
            nullable = false
    )
    private BigDecimal impStatoAc;

    @Column(
            name = "imp_regione_ac",
            nullable = false
    )
    private BigDecimal impRegioneAc;

    @Column(
            name = "imp_anticipo_cert_adg",
            nullable = false
    )
    private BigDecimal impAnticipoCertAdg;

    @Column(
            name = "imp_anticipo_cert_ac",
            nullable = false
    )
    private BigDecimal impAnticipoCertAc;

    @Column(
            name = "fg_sospensione",
            nullable = false
    )
    private String fgSospensione;

    @Column(name = "imp_decert_ant")
    private BigDecimal impDecertAnt;

    @Column(name = "imp_decert_tot")
    private BigDecimal impDecertTot;

    @Column(name = "imp_decert_ada")
    private BigDecimal impDecertAda;

    @Column(name = "imp_decert_rev")
    private BigDecimal impDecertRev;

    @Column(
            name = "fg_assistenza_tecnica",
            nullable = false
    )
    private String fgAssistenzaTecnica;

    @Column(name = "imp_strum_finanz_tot")
    private BigDecimal impStrumFinanzTot;

    @Column(name = "imp_strum_finanz_pubb")
    private BigDecimal impStrumFinanzPubb;
}
