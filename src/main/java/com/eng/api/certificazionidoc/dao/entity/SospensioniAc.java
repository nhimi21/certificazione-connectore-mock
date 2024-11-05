package com.eng.api.certificazionidoc.dao.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_sospensioni_ac")
@Entity
public class SospensioniAc {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "id_sospensione",
            nullable = false
    )
    private Integer idSospensione;

    /**
     * JOIN t_certificazioni on id_certificazione = fk_certificazione
     */
//    @Column(
//            name = "fk_certificazione",
//            nullable = false
//    )
//    private Integer fkCertificazione;

    @Column(
            name = "key_progetto",
            nullable = false
    )
    private String keyProgetto;

    @Column(
            name = "fg_stato_sospensione",
            nullable = false
    )
    private String fgStatoSospensione;

    @ManyToOne
    @JoinColumn(
            name = "fk_certificazione",
            referencedColumnName = "id_certificazione",
            nullable = false,
            insertable = false,
            updatable = false
    )
    private Certificazioni Certificazioni;
}
