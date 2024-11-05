package com.eng.api.certificazionidoc.dao.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(
        name = "t_certificazione_parametri"
)
@Entity
public class CertificazioneParametri {
    /**
     * JOIN t_certificazioni on id_certificazione = fk_certificazione
     */
    @Id
    @EqualsAndHashCode.Include
    @Column(
            name = "fk_certificazione",
            nullable = false
    )
    private Integer fkCertificazione;

    /**
     * JOIN t_cod_parametri on id_parametro = fk_parametro
     */
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
