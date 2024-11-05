package com.eng.api.certificazionidoc.dao.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(
    name = "t_sospensioni_ac_det"
)
@Entity
public class SospensioniAcDet {
  @Id
  @EqualsAndHashCode.Include
  @GeneratedValue(
      strategy = GenerationType.IDENTITY
  )
  @Column(
      name = "id_sospensione_det",
      nullable = false
  )
  private Integer idSospensioneDet;

  /**
   * JOIN t_sospensioni_ac on id_sospensione = fk_sospensione
   */
  @Column(
      name = "fk_sospensione",
      nullable = false
  )
  private Integer fkSospensione;

  @Column(name = "key_rich_rimborso")
  private String keyRichRimborso;

  @Column(name = "key_giustificativo")
  private String keyGiustificativo;

  @Column(name = "key_voce_spesa")
  private String keyVoceSpesa;

  @Column(
      name = "imp_sospeso",
      nullable = false
  )
  private BigDecimal impSospeso;
}
