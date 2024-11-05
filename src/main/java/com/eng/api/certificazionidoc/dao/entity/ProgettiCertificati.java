package com.eng.api.certificazionidoc.dao.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@IdClass(ProgettiCertificatiId.class)
@Table(
        name = "t_progetti_certificati"
)
@Entity
public class ProgettiCertificati {
    @Id
    @EqualsAndHashCode.Include
    @Column(
            name = "key_progetto",
            nullable = false
    )
    private String keyProgetto;

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

    @Column(
            name = "imp_anticipo",
            nullable = false
    )
    private BigDecimal impAnticipo;
}
