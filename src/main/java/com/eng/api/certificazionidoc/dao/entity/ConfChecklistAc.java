package com.eng.api.certificazionidoc.dao.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(
        name = "t_conf_checklist_ac"
)
@Entity
public class ConfChecklistAc {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "id_checklist_conf",
            nullable = false
    )
    private Integer idChecklistConf;

    @Column(
            name = "fk_programma",
            nullable = false
    )
    private Integer fkProgramma;

    @Column(
            name = "de_checklist",
            nullable = false
    )
    private String deChecklist;

    @Column(
            name = "data_inizio_validita",
            nullable = false
    )
    private Date dataInizioValidita;

    @Column(name = "data_fine_validita")
    private Date dataFineValidita;

    @Column(
            name = "fg_tipo_checklist",
            nullable = false
    )
    private String fgTipoChecklist;
}
