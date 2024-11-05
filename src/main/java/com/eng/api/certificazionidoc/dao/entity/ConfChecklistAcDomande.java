package com.eng.api.certificazionidoc.dao.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(
        name = "t_conf_checklist_ac_domande"
)
@Entity
public class ConfChecklistAcDomande {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "id_checklist_dom_conf",
            nullable = false
    )
    private Integer idChecklistDomConf;

    /**
     * JOIN t_conf_checklist_ac_sezioni on id_checklist_sez_conf = fk_checklist_sez_conf
     */
    @Column(
            name = "fk_checklist_sez_conf",
            nullable = false
    )
    private Integer fkChecklistSezConf;

    @Column(
            name = "de_domanda",
            nullable = false
    )
    private String deDomanda;

    @Column(
            name = "fg_tipo_risposta",
            nullable = false
    )
    private String fgTipoRisposta;
}
