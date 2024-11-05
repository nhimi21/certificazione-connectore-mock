package com.eng.api.certificazionidoc.dao.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(
        name = "t_cod_programmi"
)
@Entity
public class CodProgrammi {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "id_programma",
            nullable = false
    )
    private Integer idProgramma;

    @Column(
            name = "cod_programma",
            nullable = false
    )
    private String codProgramma;

    @Column(
            name = "de_programma",
            nullable = false
    )
    private String deProgramma;

    @Column(
            name = "fg_tipo_programma",
            nullable = false
    )
    private String fgTipoProgramma;

    @Column(
            name = "cod_programmazione",
            nullable = false
    )
    private String codeProgrammazione;

    @JsonIgnore
    @OneToMany(mappedBy = "codProgrammi")
    private List<Certificazioni> certificazioniList;
}
