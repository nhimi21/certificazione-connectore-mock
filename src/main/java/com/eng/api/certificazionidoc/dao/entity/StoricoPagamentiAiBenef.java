package com.eng.api.certificazionidoc.dao.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@IdClass(StoricoPagamentiAiBenefId.class)
@Table(
        name = "t_storico_pagamenti_ai_benef"
)
@Entity
public class StoricoPagamentiAiBenef {
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
            name = "key_pagamento",
            nullable = false
    )
    private String keyPagamento;

    @Column(
            name = "key_fonte",
            nullable = false
    )
    private String keyFonte;

    /**
     * JOIN t_storico_rich_rimborso on id_rich_rimborso = key_rich_rimborso
     */
    @Column(
            name = "key_rich_rimborso",
            nullable = false
    )
    private String keyRichRimborso;

    @Column(
            name = "imp_pagamento",
            nullable = false
    )
    private BigDecimal impPagamento;

    @Column(
            name = "imp_pagamento_cert_adg",
            nullable = false
    )
    private BigDecimal impPagamentoCertAdg;

    @Column(
            name = "imp_pagamento_cert_ac",
            nullable = false
    )
    private BigDecimal impPagamentoCertAc;

    @Column(
            name = "data_pagamento",
            nullable = false
    )
    private Date dataPagamento;

    @Column(
            name = "soggetto_pagamento",
            nullable = false
    )
    private String soggettoPagamento;

    @Column(name = "ae_mandato")
    private String aeMandato;

    @Column(name = "mandato")
    private String mandato;

    @Column(name = "id_riga_mandato")
    private String idRigaMandato;

    @Column(name = "cod_pagamento")
    private String codPagamento;

    @Column(
            name = "fg_tipo_pagamento",
            nullable = false
    )
    private String fgTipoPagamento;

    @Column(name = "note")
    private String note;
}
