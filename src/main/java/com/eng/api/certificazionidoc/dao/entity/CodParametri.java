package com.eng.api.certificazionidoc.dao.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(
        name = "t_cod_parametri"
)
@Entity
public class CodParametri {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "id_parametro",
            nullable = false
    )
    private Integer idParametro;

    @Column(
            name = "cod_parametro",
            nullable = false,
            unique = true
    )
    private String codParametro;

    @Column(
            name = "de_parametro",
            nullable = false
    )
    private String deParametro;
}
