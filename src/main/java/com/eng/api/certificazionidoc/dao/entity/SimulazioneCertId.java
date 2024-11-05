package com.eng.api.certificazionidoc.dao.entity;

import lombok.*;

import javax.persistence.Id;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SimulazioneCertId implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    private Integer fkProgramma;

    @Id
    @EqualsAndHashCode.Include
    private Integer keyProgetto;
}
