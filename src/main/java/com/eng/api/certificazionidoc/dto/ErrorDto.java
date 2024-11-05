package com.eng.api.certificazionidoc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDto {
    private String error;
    private Integer status;
    private Date timeStamp;
    private String path;
    private String message;
}