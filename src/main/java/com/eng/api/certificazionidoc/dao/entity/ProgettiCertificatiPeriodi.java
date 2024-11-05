package com.eng.api.certificazionidoc.dao.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@IdClass(ProgettiCertificatiPeriodiId.class)
@Table(name = "t_progetti_certificati_periodi")
@Entity
public class ProgettiCertificatiPeriodi {
    @Id
    @EqualsAndHashCode.Include
    @Column(
            name = "key_progetto",
            length = 50,
            nullable = false
    )
    private String keyProgetto;

    /**
     * JOIN t_cod_periodi_contabili on id_periodo_contabile = fk_periodo_contabile
     */
    @Id
    @EqualsAndHashCode.Include
    @Column(
            name = "fk_periodo_contabile",
            nullable = false
    )
    private Integer fkPeriodoContabile;

    @Id
    @EqualsAndHashCode.Include
    @Column(
            name = "fk_programma",
            nullable = false
    )
    private Integer fkProgramma;

    @Column(
            name = "cod_priorita",
            nullable = false
    )
    private String codPriorita;

    @Column(
            name = "cod_obiettivo",
            nullable = false
    )
    private String codeObiettivo;

    @Column(
            name = "cod_azione",
            nullable = false
    )
    private String codAzione;

    @Column(
            name = "imp_certificato",
            nullable = false
    )
    private BigDecimal impCertificato;

    @Column(
            name = "imp_ue",
            nullable = false
    )
    private BigDecimal impUe;

    @Column(
            name = "imp_stato",
            nullable = false
    )
    private BigDecimal impStato;

    @Column(
            name = "imp_regione",
            nullable = false
    )
    private BigDecimal impRegione;

    @ManyToOne
    @JoinColumn(
            name = "fk_periodo_contabile",
            referencedColumnName = "id_periodo_contabile",
            insertable = false,
            updatable = false
    )
    private CodPeriodiContabili periodiContabili;
}
