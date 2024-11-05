package com.eng.api.certificazionidoc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Esclusioni {
    private List<String> codBandi;
    private List<String> codProgetti;
    private List<String> codPriorita;
    private List<String> codObiettivi;
    private List<String> codAzioni;
}
