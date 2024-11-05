package com.eng.api.certificazionidoc.dao.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(
        name = "t_cert_checklist_ac_domande"
)
@Entity
public class CertChecklistAcDomande {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "id_checklist_dom_cert",
            nullable = false
    )
    private Integer idChecklistDomCert;

    /**
     * JOIN t_conf_checklist_ac_domande on id_checklist_dom_conf = fk_checklist_dom_conf
     */
    @Column(
            name = "fk_checklist_dom_conf",
            nullable = false
    )
    private Integer fkChecklistDomConf;

    @Column(name = "risposta")
    private String risposta;
}
