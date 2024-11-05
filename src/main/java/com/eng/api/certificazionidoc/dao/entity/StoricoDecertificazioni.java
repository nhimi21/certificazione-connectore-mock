package com.eng.api.certificazionidoc.dao.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@IdClass(StoricoDecertificazioniId.class)
@Table(
        name = "t_storico_decertificazioni"
)
@Entity
public class StoricoDecertificazioni {
    @Id
    @EqualsAndHashCode.Include
    @Column(
            name = "key_decertificazione",
            nullable = false
    )
    private String keyDecertificazione;

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

    @Column(name = "key_giustificativo")
    private String keyGiustificativo;

    @Column(name = "key_voce_spesa")
    private String keyVoceSpesa;

    @Column(name = "key_rich_rimborso")
    private String keyRichRimborso;

    @Column(
            name = "fg_tipo_decertificazione",
            nullable = false
    )
    private String fgTipoDecertificazione;

    /**
     * JOIN t_storico_decertificazioni on id_decertificazione = fk_origine_decert
     */
//    @Column(
//            name = "fk_origine_decert",
//            nullable = false
//    )
//    private Integer fkOrigineDecert;

    @ManyToOne
    @JoinColumn(
            name = "fk_origine_decert",
            referencedColumnName = "id_origine_decert",
            nullable = false
    )
    private CodOrigineDecertificazioni codOrigineDecertificazioni;

    @Column(name = "imp_errato")
    private BigDecimal impErrato;

    @Column(
            name = "imp_decertificazione",
            nullable = false
    )
    private BigDecimal impDecertificazione;

    /**
     * JOIN t_certificazioni on id_certificazione = fk_certificazione_rif
     */
    @ManyToOne
    @JoinColumn(
            name = "fk_certificazione_rif",
            referencedColumnName = "id_certificazione",
            nullable = false
    )
    private Certificazioni certificazioni;

    @Column(name = "note")
    private String note;

    @Column(name = "fg_irregolarita")
    private String fgIrregolarita;

    @Column(name = "fg_conferma_sosp")
    private String fgConfermaSosp = "N";
}
