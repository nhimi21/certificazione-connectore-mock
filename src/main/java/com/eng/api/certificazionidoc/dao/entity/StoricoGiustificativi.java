package com.eng.api.certificazionidoc.dao.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@IdClass(StoricoGiustificativiId.class)
@Table(
        name = "t_storico_giustificativi"
)
@Entity
public class StoricoGiustificativi {
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

    /**
     * JOIN t_storico_rich_rimborso on id_rich_rimborso = fk_rich_rimborso
     */
    @Id
    @EqualsAndHashCode.Include
    @Column(
            name = "fk_rich_rimborso",
            nullable = false
    )
    private Integer fkRichRimborso;

    @Id
    @EqualsAndHashCode.Include
    @Column(
            name = "key_giustificativo",
            nullable = false
    )
    private String keyGiustificativo;

    @Column(
            name = "key_fonte",
            nullable = false
    )
    private String keyFonte;

    @Column(
            name = "data_quietanza",
            nullable = false
    )
    private Date dataQuietanza;

    @Column(name = "cf_fornitore")
    private String cfFornitore;

    @Column(name = "de_fornitore")
    private String deFornitore;

    @Column(name = "cod_documento")
    private String codDocumento;

    @Column(name = "data_documento")
    private Date dataDocumento;

    @Column(name = "tipo_documento")
    private String tipoDocumento;

    @Column(name = "note")
    private String note;
}
