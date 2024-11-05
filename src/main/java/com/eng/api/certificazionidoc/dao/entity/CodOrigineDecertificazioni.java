package com.eng.api.certificazionidoc.dao.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(
        name = "t_cod_origine_decertificazioni"
)
@Entity
public class CodOrigineDecertificazioni {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "id_origine_decert",
            nullable = false
    )
    private Integer idOrigineDecert;

    @Column(
            name = "cod_origine_decert",
            nullable = false
    )
    private String codOrigineDecert;

    @Column(
            name = "de_origine_decert",
            nullable = false
    )
    private String deOrigineDecert;

    @JsonIgnore
    @OneToMany(mappedBy = "codOrigineDecertificazioni")
    private List<StoricoDecertificazioni> storicoDecertificazionis;
}
