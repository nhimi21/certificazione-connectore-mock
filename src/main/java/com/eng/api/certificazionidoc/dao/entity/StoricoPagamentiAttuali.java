package com.eng.api.certificazionidoc.dao.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@IdClass(StoricoPagamentiAttualiId.class)
@Table(
        name = "t_storico_pagamenti_attuali"
)
@Entity
public class StoricoPagamentiAttuali {
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
    private String keyProgetto;

    @Id
    @EqualsAndHashCode.Include
    @Column(
            name = "key_rich_rimborso",
            nullable = false
    )
    private String keyRichRimborso;

    @Id
    @EqualsAndHashCode.Include
    @Column(
            name = "key_pagamento",
            nullable = false
    )
    private String keyPagamento;

    @Column(
            name = "key_fonte",
            nullable = false
    )
    private String keyFonte;

    @Column(
            name = "cod_protocollo",
            nullable = false
    )
    private String codProtocollo;

    @Id
    @EqualsAndHashCode.Include
    @Column(
            name = "data_protocollo",
            nullable = false
    )
    private Date dataProtocollo;

    @Column(
            name = "imp_rich_rimborso",
            nullable = false
    )
    private BigDecimal impRichRimborso;

    @Column(
            name = "fg_tipo_rich_rimborso",
            nullable = false
    )
    private String fgTipoRichRimborso;

    @Column(name = "cod_pagamento")
    private String codPagamento;

    @Column(name = "data_pagamento")
    private Date dataPagamento;

    @Column(name = "imp_pagamento")
    private BigDecimal impPagamento;
}
