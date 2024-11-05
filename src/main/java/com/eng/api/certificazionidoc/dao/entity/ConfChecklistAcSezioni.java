package com.eng.api.certificazionidoc.dao.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(
        name = "t_conf_checklist_ac_sezioni"
)
@Entity
public class ConfChecklistAcSezioni {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "id_checklist_sez_conf",
            nullable = false
    )
    private Integer idChecklistSezConf;

    /**
     * JOIN t_conf_checklist_ac on id_checklist_conf = fk_checklist_conf
     */
    @Column(
            name = "fk_checklist_conf",
            nullable = false
    )
    private Integer fkChecklistConf;

    @Column(
            name = "de_sezione",
            nullable = false
    )
    private String deSezione;
}
