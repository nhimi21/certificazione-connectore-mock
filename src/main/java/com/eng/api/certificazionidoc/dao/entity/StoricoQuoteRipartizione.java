package com.eng.api.certificazionidoc.dao.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@IdClass(StoricoQuoteRipartizioneId.class)
@Table(
    name = "t_storico_quote_ripartizione"
)
@Entity
public class StoricoQuoteRipartizione {
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

  /**
   * JOIN t_cod_periodi_contabili on id_periodo_contabile = fk_periodo_contabile
   */
  @Id
  @EqualsAndHashCode.Include
  @Column(
      name = "fk_periodo_contabile",
      nullable = false
  )
  private Integer fkPeriodoContabile;

  @Column(
      name = "perc_quota_ue",
      nullable = false
  )
  private BigDecimal percQuotaUe;

  @Column(
      name = "perc_quota_stato",
      nullable = false
  )
  private BigDecimal percQuotaStato;

  @Column(
      name = "perc_quota_regione",
      nullable = false
  )
  private BigDecimal percQuotaRegione;
}
