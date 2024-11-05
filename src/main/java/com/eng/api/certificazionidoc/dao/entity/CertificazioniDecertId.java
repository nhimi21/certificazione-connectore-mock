package com.eng.api.certificazionidoc.dao.entity;

import lombok.*;

import javax.persistence.Id;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CertificazioniDecertId implements Serializable {
    @Id
//    @EqualsAndHashCode.Include
    private String keyDecertificazione;

    @Id
    @EqualsAndHashCode.Include
    private Integer fkCertificazione;
}
