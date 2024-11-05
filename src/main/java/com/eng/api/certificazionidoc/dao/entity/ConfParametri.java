package com.eng.api.certificazionidoc.dao.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@IdClass(ConfParametriId.class)
@Table(
        name = "t_conf_parametri"
)
@Entity
public class ConfParametri {
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

    /**
     * JOIN t_cod_parametri on id_parametro = fk_parametro
     */
    @Id
    @EqualsAndHashCode.Include
    @Column(
            name = "fk_parametro",
            nullable = false
    )
    private Integer fkParametro;

    @Column(
            name = "fg_attivo",
            nullable = false
    )
    private String fgAttivo;
}
