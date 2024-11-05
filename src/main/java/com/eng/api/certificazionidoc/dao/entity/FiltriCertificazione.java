package com.eng.api.certificazionidoc.dao.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(
        name = "t_filtri_certificazione"
)
@Entity
public class FiltriCertificazione {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "id_filtro",
            nullable = false
    )
    private Integer idFiltro;

    /**
     * JOIN t_cod_programmi on id_programma = fk_programma
     */
    @Column(
            name = "fk_programma",
            nullable = false
    )
    private Integer fkProgramma;

    @Column(name = "key_bando")
    private String keyBando;

    @Column(name = "cod_bando")
    private String codBando;

    @Column(name = "de_bando")
    private String deBando;

    @Column(name = "key_progetto")
    private String keyProgetto;

    @Column(name = "cod_progetto")
    private String codProgetto;

    @Column(name = "titolo_progetto")
    private String titoloProgetto;

    @Column(name = "fg_tipo_filtro")
    private String fgTipoFiltro;
}
