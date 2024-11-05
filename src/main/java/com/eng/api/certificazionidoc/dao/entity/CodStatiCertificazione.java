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
        name = "t_cod_stati_certificazione"
)
@Entity
public class CodStatiCertificazione {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "id_stato_cert",
            nullable = false
    )
    private Integer idStatoCert;

    @Column(
            name = "cod_stato_cert",
            nullable = false
    )
    private String codStatoCert;

    @Column(
            name = "de_stato_cert",
            nullable = false
    )
    private String deStatoCert;

    @Column(
            name = "fg_chiusura",
            nullable = false
    )
    private String fgChiusura;

    @JsonIgnore
    @OneToMany(mappedBy = "codStatiCertificazione")
    private List<Certificazioni> certificazioniList;
}
