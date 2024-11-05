package com.eng.api.certificazionidoc.exception;

import com.eng.api.certificazionidoc.enums.ErrorCode;
import lombok.Getter;

@Getter
public class CertificazioniException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private final ErrorCode errorCode;
    private final String message;

    public CertificazioniException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
        this.message = null;
    }

    public CertificazioniException(ErrorCode errorCode, String message) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
        this.message = message;
    }

	/*public CertificazioniException() {
		super();
	}

	public CertificazioniException(String message, Throwable cause) {
		super(message, cause);
	}*/

//	public CertificazioniException(String message) {
//		super(message);
//	}

	/*public CertificazioniException(Throwable cause) {
		super(cause);
	}*/

    public static CertificazioniException ERR_PERIODO_CODEEXISTS = new CertificazioniException(ErrorCode.INTERNAL_SERVER_ERROR, "Codice periodo già presente.");
    public static CertificazioniException ERR_PERIODO_OVERLAP = new CertificazioniException(ErrorCode.INTERNAL_SERVER_ERROR, "Il periodo si sovrappone a periodi esistenti.");
    public static CertificazioniException ERR_PERIODO_WRONGSEQ = new CertificazioniException(ErrorCode.INTERNAL_SERVER_ERROR, "Data inizio periodo deve essere minore di data fine periodo.");
}
