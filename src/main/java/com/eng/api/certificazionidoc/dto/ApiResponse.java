package com.eng.api.certificazionidoc.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ApiResponse {
    private String status;
    private Integer requestId;
    private Boolean letturaParziale;
    private String programma;
    private Esclusioni esclusioni;
    private Date creationTime;
    private Date updateTime;
    private String message;
}
