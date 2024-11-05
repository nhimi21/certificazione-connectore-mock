package com.eng.api.certificazionidoc.dao.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@IdClass(CertificazioniDecertId.class)
@Table(
        name = "t_certificazioni_decert"
)
@Entity
public class CertificazioniDecert {
    /**
     * JOIN t_storico_decertificazioni on fk_certificazione = fk_certificazione
     */
    @Id
    @EqualsAndHashCode.Include
    @Column(
            name = "fk_certificazione",
            nullable = false
    )
    private Integer fkCertificazione;

    /**
     * JOIN t_storico_decertificazioni on key_decertificazione = key_decertificazione
     */
    @Id
    @EqualsAndHashCode.Include
    @Column(
            name = "key_decertificazione",
            nullable = false
    )
    private String keyDecertificazione;

    @Column(
            name = "key_fonte",
            nullable = false
    )
    private String keyFonte;

    @Column(
            name = "key_progetto",
            nullable = false
    )
    private String keyProgetto;

    @Column(name = "key_rich_rimborso")
    private String keyRichRimborso;

    @Column(name = "key_giustificativo")
    private String keyGiustificativo;

    @Column(
            name = "key_voce_spesa",
            nullable = false
    )
    private String keyVoceSpesa;

    @Column(
            name = "fg_irregolarita",
            nullable = false
    )
    private String fgIrregolarita;

    @Column(
            name = "fg_modalita",
            nullable = false
    )
    private String fgModalita;

    @Column(
            name = "fg_tipo_decertificazione",
            nullable = false
    )
    private String fgTipoDecertificazione;

    /**
     * JOIN t_cod_origine_decertificazioni on id_origine_decert = fk_origine_decert
     */
    @Column(
            name = "fk_origine_decert",
            nullable = false
    )
    private Integer fkOrigineDecert;

    @Column(name = "rif_documento")
    private String rifDocumento;

    @Column(name = "imp_ammesso_errato")
    private BigDecimal impAmmessoErrato;

    @Column(
            name = "imp_errato",
            nullable = false
    )
    private BigDecimal impErrato;

    @Column(
            name = "imp_decertificazione",
            nullable = false
    )
    private BigDecimal impDecertificazione;

    /**
     * JOIN t_certificazioni on id_certificazione = fk_certificazione_rif
     */
    @Column(
            name = "fk_certificazione_rif",
            nullable = false
    )
    private Integer fkCertificazioneRif;

    @Column(
            name = "motivazione_decert",
            nullable = false
    )
    private String motivazioneDecert;

    @Column(name = "note")
    private String note;

    @Column(
            name = "fg_conferma_sosp",
            nullable = false
    )
    private String fgConfermaSosp;

    @Column(name = "rif_scheda_olaf")
    private String rifSchedaOlaf;

    @Column(name = "note_ac_interne")
    private String noteAcInterne;

    @Column(name = "note_ac_pubbliche")
    private String noteAcPubbliche;
}
