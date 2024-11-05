package com.eng.api.certificazionidoc.dao.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@IdClass(StoricoRichRimborsoId.class)
@Table(
        name = "t_storico_rich_rimborso"
)
@Entity
public class StoricoRichRimborso {
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
            name = "key_progetto",
            nullable = false
    )
    private Integer keyProgetto;

    @Id
    @EqualsAndHashCode.Include
    @Column(
            name = "key_rich_rimborso",
            nullable = false
    )
    private String keyRichRimborso;

    @Column(
            name = "key_fonte",
            nullable = false
    )
    private String keyFonte;

    @Column(
            name = "data_rich_rimborso",
            nullable = false
    )
    private Date dataRichRimborso;

    @Column(name = "cod_protocollo")
    private String codProtocollo;

    @Column(name = "data_protocollo")
    private Date dataProtocollo;

    @Column(name = "imp_anticipo")
    private BigDecimal impAnticipo;

    @Column(
            name = "fg_tipo_rich_rimborso",
            nullable = false
    )
    private String fgTipoRichRimborso;
}
