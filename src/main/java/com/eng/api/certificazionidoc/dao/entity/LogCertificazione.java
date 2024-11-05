package com.eng.api.certificazionidoc.dao.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(
        name = "t_log_certificazione"
)
@Entity
public class LogCertificazione {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "id_log",
            nullable = false
    )
    private Integer idLog;

    /**
     * JOIN t_certificazioni on id_certificazione = fk_certificazione
     */
    @Column(name = "fk_certificazione")
    private Integer fkCertificazione;

    @Column(
            name = "data_log",
            nullable = false
    )
    private Date dataLog;

    @Column(
            name = "key_progetto",
            nullable = false
    )
    private String keyProgetto;

    @Column(
            name = "cod_progetto",
            nullable = false
    )
    private String codProgetto;

    @Column(
            name = "de_log",
            nullable = false
    )
    private String deLog;
}
