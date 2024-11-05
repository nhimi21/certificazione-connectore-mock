package com.eng.api.certificazionidoc.dao.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(
        name = "t_cert_checklist_ac"
)
@Entity
public class CertChecklistAc {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "id_checklist_cert",
            nullable = false
    )
    private Integer idChecklistCert;

    /**
     * JOIN t_certificazioni on id_certificazione = fk_certificazione
     */
    @Column(
            name = "fk_certificazione",
            nullable = false
    )
    private Integer fkCertificazione;

    /**
     * JOIN t_conf_checklist_ac on id_checklist_conf = fk_checklist_conf
     */
    @Column(
            name = "fk_checklist_conf",
            nullable = false
    )
    private Integer fkChecklistConf;

    @Column(name = "note")
    private String note;
}
