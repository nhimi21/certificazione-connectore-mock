package com.eng.api.certificazionidoc.dao.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(
    name = "t_storico_giustificativi_d"
)
@Entity
public class StoricoGiustificativiD {
  @Id
  @EqualsAndHashCode.Include
  @GeneratedValue(
      strategy = GenerationType.IDENTITY
  )
  @Column(
      name = "id_giustificativo_d",
      nullable = false
  )
  private Integer idGiustificativoD;

  /**
   * JOIN t_certificazioni on id_certificazione = fk_certificazione
   */
  @Column(
      name = "fk_certificazione",
      nullable = false
  )
  private Integer fkCertificazione;

  /**
   * JOIN t_storico_giustificativi on id_giustificativo = fk_giustificativo
   */
  @Column(
      name = "fk_giustificativo",
      nullable = false
  )
  private Integer fkGiustificativo;

  @Column(
      name = "key_voce_spesa",
      nullable = false
  )
  private String keyVoceSpesa;

  @Column(
      name = "cod_voce_spesa",
      nullable = false
  )
  private String codVoceSpesa;

  @Column(
      name = "de_voce_spesa",
      nullable = false
  )
  private String deVoceSpesa;

  @Column(
      name = "imp_presentato",
      nullable = false
  )
  private BigDecimal impPresentato;

  @Column(
      name = "imp_ammesso",
      nullable = false
  )
  private BigDecimal impAmmesso;

  @Column(
      name = "imp_maturato",
      nullable = false
  )
  private BigDecimal impMaturato;

  @Column(
      name = "imp_certificato_adg",
      nullable = true
  )
  private BigDecimal impCertificatoAdg;

  @Column(
      name = "imp_certificato_ac",
      nullable = true
  )
  private BigDecimal impCertificatoAc;

  @Column(
      name = "costo_standard",
      nullable = true
  )
  private BigDecimal costoStandard;

  @Column(
      name = "quantita",
      nullable = true
  )
  private Integer quantita;

  @Column(
      name = "tipo_voce",
      nullable = false
  )
  private String tipoVoce;
}
