package com.eng.api.certificazionidoc.dao.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@IdClass(StoricoTagliId.class)
@Table(name = "t_storico_tagli")
@Entity
public class StoricoTagli {
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

    @Id
    @EqualsAndHashCode.Include
    @Column(
            name = "key_taglio",
            nullable = false
    )
    private String keyTaglio;

    @Column(
            name = "key_fonte",
            nullable = false
    )
    private String keyFonte;

    @Column(
            name = "key_progetto",
            nullable = false
    )
    private String keyProgetto;

    @Column(name = "key_giustificativo")
    private String keyGiustificativo;

    @Column(name = "key_voce_spesa")
    private String keyVoceSpesa;

    @Column(
            name = "fg_tipo_taglio",
            nullable = false
    )
    private String fgTipoTaglio;

    @Column(
            name = "imp_taglio",
            nullable = false
    )
    private BigDecimal impTaglio;

    @Column(name = "note")
    private String note;
}
