package com.eng.api.certificazionidoc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestDto {
    private Boolean getLetturaParziale;
    List<Esclusioni> esclusioni;
}
