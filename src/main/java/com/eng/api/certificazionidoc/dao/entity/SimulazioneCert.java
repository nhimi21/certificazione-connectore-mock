package com.eng.api.certificazionidoc.dao.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@IdClass(SimulazioneCertId.class)
@Table(
        name = "t_simulazione_cert"
)
@Entity
public class SimulazioneCert {
    /**
     * JOIN t_cod_programmi on id_programma = fk_programma
     */
    @Id
    @EqualsAndHashCode.Include
    @Column(
            name = "fk_programma",
            nullable = false
    )
    private Integer fkProgramma;

    @Id
    @EqualsAndHashCode.Include
    @Column(
            name = "key_progetto",
            nullable = false
    )
    private Integer keyProgetto;

    @Column(
            name = "data_simulazione",
            nullable = false
    )
    private Date dataSimulazione;

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

    @Column(
            name = "imp_decert_ant",
            nullable = false
    )
    private BigDecimal impDecertAnt;

    @Column(
            name = "imp_decert_tot",
            nullable = false
    )
    private BigDecimal impDecertTot;

    @Column(
            name = "imp_decert_ada",
            nullable = false
    )
    private BigDecimal impDecertAda;

    @Column(
            name = "fg_sospensione",
            nullable = false
    )
    private String fgSospensione;
}
