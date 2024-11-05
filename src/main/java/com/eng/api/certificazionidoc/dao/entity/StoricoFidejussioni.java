package com.eng.api.certificazionidoc.dao.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@IdClass(StoricoFidejussioniId.class)
@Table(name = "t_storico_fidejussioni")
@Entity
public class StoricoFidejussioni {
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
            name = "key_fidejussione",
            nullable = false
    )
    private String keyFidejussione;

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

    @Column(
            name = "cod_fidejussione",
            nullable = false
    )
    private String codFidejussione;

    @Column(
            name = "data_fidejussione",
            nullable = false
    )
    private Date dataFidejussione;

    @Column(
            name = "data_inizio_validita",
            nullable = false
    )
    private Date dataInizioValidita;

    @Column(
            name = "data_fine_validita",
            nullable = false
    )
    private Date dataFineValidita;

    @Column(
            name = "de_soggetto_emitt",
            nullable = false
    )
    private String deSoggettoEmitt;

    @Column(name = "ind_soggetto_emitt")
    private String indSoggettoEmitt;

    @Column(
            name = "de_soggetto_contr",
            nullable = false
    )
    private String deSoggettoContr;

    @Column(name = "ind_soggetto_contr")
    private String indSoggettoContr;

    @Column(
            name = "imp_coperto",
            nullable = false
    )
    private BigDecimal impCoperto;
}
