package com.eng.api.certificazionidoc.enums;

import lombok.Getter;

@Getter
public enum ErrorCode {
    INVALID_CREDENTIALS("ERR001", "Username or password is incorrect!"),
    ACCESS_DENIED("ERR002", "Not Authorized"),
    JWT_EXPIRED("ERR003", "JWT token is expired"),
    JWT_SIGNATURE_INVALID("ERR004", "JWT signature not valid"),
    INSUFFICIENT_STOCK("ERR005", "Insufficient stock for order"),
    INTERNAL_SERVER_ERROR("ERR006", "Internal Server Error");

    private final String code;
    private final String message;

    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
