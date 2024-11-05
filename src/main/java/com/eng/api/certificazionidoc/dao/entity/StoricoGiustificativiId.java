package com.eng.api.certificazionidoc.dao.entity;

import lombok.*;

import javax.persistence.Id;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StoricoGiustificativiId implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private Integer fkCertificazione;

    @Id
    @EqualsAndHashCode.Include
    private Integer keyProgetto;

    @Id
    @EqualsAndHashCode.Include
    private Integer fkRichRimborso;

    @Id
    @EqualsAndHashCode.Include
    private String keyGiustificativo;
}
