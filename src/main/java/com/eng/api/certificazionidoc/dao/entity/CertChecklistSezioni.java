package com.eng.api.certificazionidoc.dao.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(
        name = "t_cert_checklist_sezioni"
)
@Entity
public class CertChecklistSezioni {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "id_checklist_sez_cert",
            nullable = false
    )
    private Integer idChecklistSezCert;

    /**
     * JOIN t_conf_checklist_ac_sezioni on id_checklist_sez_conf = fk_checklist_sez_conf
     */
    @Column(
            name = "fk_checklist_sez_conf",
            nullable = false
    )
    private Integer fkChecklistSezConf;
}
