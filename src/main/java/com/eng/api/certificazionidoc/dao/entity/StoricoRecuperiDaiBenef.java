package com.eng.api.certificazionidoc.dao.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@IdClass(StoricoRecuperiDaiBenefId.class)
@Table(
        name = "t_storico_recuperi_dai_benef"
)
@Entity
public class StoricoRecuperiDaiBenef {
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
            name = "key_recupero",
            nullable = false
    )
    private String keyRecupero;

    @Column(
            name = "key_fonte",
            nullable = false
    )
    private String keyFonte;

    @Column(
            name = "imp_recupero",
            nullable = false
    )
    private BigDecimal impRecupero;

    @Column(
            name = "data_recupero",
            nullable = false
    )
    private Date dataRecupero;

    @Column(
            name = "soggetto_recupero",
            nullable = false
    )
    private String soggettoRecupero;

    @Column(name = "ae_reversale")
    private String aeReversale;

    @Column(name = "reversale")
    private String reversale;

    @Column(name = "id_riga_reversale")
    private String idRigaReversale;

    @Column(name = "cod_recupero")
    private String codRecupero;

    @Column(
            name = "fg_tipo_recupero",
            nullable = false
    )
    private String fgTipoRecupero;

    @Column(name = "note")
    private String note;
}
