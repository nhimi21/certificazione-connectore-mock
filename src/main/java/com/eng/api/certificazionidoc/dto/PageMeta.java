package com.eng.api.certificazionidoc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageMeta {
    private int pageNumber;
    private int pageSize;
    private long totalElements;
    private int totalPages;
}
