package com.eng.api.certificazionidoc.dao.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(
        name = "t_cod_periodi_contabili"
)
@Entity
public class CodPeriodiContabili {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "id_periodo_contabile",
            nullable = false
    )
    private Integer idPeriodoContabile;

    @Column(
            name = "cod_periodo_contabile",
            nullable = false
    )
    private String codPeriodoContabile;

    @Column(
            name = "de_periodo_contabile",
            nullable = false
    )
    private String dePeriodoContabile;

    @Column(
            name = "data_inizio",
            nullable = false
    )
    private Date dataInizio;

    @Column(
            name = "data_fine",
            nullable = false
    )
    private Date dataFine;

    @Column(
            name = "cod_programmazione",
            nullable = false
    )
    private String codProgrammazione;

    @JsonIgnore
    @OneToMany(mappedBy = "codPeriodiContabili")
    private List<Certificazioni> certificazioniList;
}
