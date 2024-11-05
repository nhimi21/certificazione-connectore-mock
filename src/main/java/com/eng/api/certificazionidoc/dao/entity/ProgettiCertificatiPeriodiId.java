package com.eng.api.certificazionidoc.dao.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProgettiCertificatiPeriodiId implements Serializable {
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
}
