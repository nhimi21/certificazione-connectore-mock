package com.eng.api.certificazionidoc.dao.entity;

import lombok.*;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StoricoPagamentiAttualiId implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    private Integer fkCertificazione;

    @Id
    @EqualsAndHashCode.Include
    private String keyProgetto;

    @Id
    @EqualsAndHashCode.Include
    private String keyRichRimborso;

    @Id
    @EqualsAndHashCode.Include
    private String keyPagamento;

    @Id
    @EqualsAndHashCode.Include
    private Date dataProtocollo;
}
