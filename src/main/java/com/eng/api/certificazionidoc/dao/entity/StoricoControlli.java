package com.eng.api.certificazionidoc.dao.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@IdClass(StoricoControlliId.class)
@Table(name = "t_storico_controlli")
@Entity
public class StoricoControlli {
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
            name = "key_controllo",
            nullable = false
    )
    private String keyControllo;

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

    @Column(name = "key_rich_rimborsa")
    private String keyRichRimborso;

    @Column(
            name = "data_inizio",
            nullable = false
    )
    private Date dataInizio;

    @Column(name = "data_fine")
    private Date dataFine;

    @Column(
            name = "soggetto_controllore",
            nullable = false
    )
    private String soggettoControllore;

    @Column(name = "fg_esito_controllo")
    private String fgEsitoControllo;

    @Column(name = "tipo_controllo")
    private String tipoControllo;

    @Column(name = "note")
    private String note;
}
