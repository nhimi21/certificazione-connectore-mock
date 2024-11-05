package com.eng.api.certificazionidoc.dao.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_certificazioni")
@Entity
public class Certificazioni {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "id_certificazione",
            nullable = false
    )
    private Integer idCertificazione;

    /**
     * JOIN t_cod_programmi on id_programma = fk_programma
     */
    @ManyToOne
    @JoinColumn(
            name = "fk_programma",
            referencedColumnName = "id_programma",
            nullable = false
    )
    private CodProgrammi codProgrammi;

    /**
     * JOIN t_cod_stati_certificazione on id_stato_cert = fk_stato_certificazione
     */
    @ManyToOne
    @JoinColumn(
            name = "fk_stato_certificazione",
            referencedColumnName = "id_stato_cert",
            nullable = false
    )
    private CodStatiCertificazione codStatiCertificazione;

    /**
     * JOIN t_cod_periodi_contabili on id_periodo_contabile = fk_periodo_contabile
     */
    @ManyToOne
    @JoinColumn(
            name = "fk_periodo_contabile",
            referencedColumnName = "id_periodo_contabile",
            nullable = false
    )
    private CodPeriodiContabili codPeriodiContabili;

    @Column(
            name = "data_certificazione",
            nullable = false
    )
    private Date dataCertificazione;

    @Column(
            name = "fg_tipo_certificazione",
            nullable = false
    )
    private String fgTipoCertificazione;

    @Column(
            name = "cod_certificazione",
            nullable = false
    )
    private String codCertificazione;

    @Column(
            name = "de_certificazione",
            nullable = false
    )
    private String deCertificazione;

    @Column(name = "note_adg")
    private String noteAdg;

    @Column(name = "note_ac")
    private String noteAc;

    @Column(name = "cod_regis")
    private String codRegis;

    @Column(name = "data_invio_sfc")
    private Date dataInvioSfc;

    @Column(name = "num_nota_adg")
    private String numNotaAdg;

    @Column(name = "data_nota_adg")
    private Date dataNotaAdg;

    /**
     * JOIN t_certificazioni on id_certificazione = fk_certificazione_prec
     */
    @Column(name = "fk_certificazione_prec")
    private Integer fkCertificazionePrec;

    /**
     * JOIN t_certificazioni on id_certificazione = fk_certificazione_delta
     */
    @Column(name = "fk_certificazione_delta")
    private Integer fkCertificazioneDelta;

    @Column(
            name = "ut_ins",
            nullable = false
    )
    private String utIns;

    @JsonIgnore
    @OneToMany(mappedBy = "certificazioni")
    List<StoricoDecertificazioni> storicoDecertificazionis;
}
