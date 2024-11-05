package com.eng.api.certificazionidoc.controller;

import com.eng.api.certificazionidoc.dto.ApiResponse;
import com.eng.api.certificazionidoc.dto.RequestDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Api(value = "/Certificazion Mock", tags = "Certificazion Mock")
@RestController
@RequestMapping("/certificazione-connector/richiesta-di-caricamento")
public class CertificazioneMockController {

    @ApiOperation(value = "Lettura di tutte le richiesta di caricamento presenti sul sistema.")
    @GetMapping
    public ResponseEntity<List<ApiResponse>> getAllRichieste() {
        List<ApiResponse> richieste = getDati();
        return new ResponseEntity<>(richieste, HttpStatus.OK);
    }

    @ApiOperation(value = "(Asincrona) - Avvio di una nuova attività di caricamento dei dati.")
    @PostMapping
    public ResponseEntity<ApiResponse> creaRichiesta(
            @RequestParam("programma") String programma,
            @RequestBody(required = false) RequestDto request) {

        ApiResponse response = new ApiResponse();
        response.setCreationTime(new Date());
        response.setProgramma(programma);
        response.setEsclusioni(response.getEsclusioni());
        response.setStatus("COMPLETED");
        response.setLetturaParziale(request.getGetLetturaParziale());
        response.setRequestId(5);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Lettura dei dati di una richiesta di caricamento.")
    @GetMapping("/{requestId}")
    public ResponseEntity<ApiResponse> getRichiestaById(@PathVariable Integer requestId) {
        List<ApiResponse> lista = getDati();
        ApiResponse response = lista.stream().filter((e) -> e.getRequestId().equals(requestId)).findFirst().orElse(null);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ApiOperation(value = "(Asincrona) - Cancella i dati di una specifica requestId.")
    @DeleteMapping("/{requestId}")
    public ResponseEntity<Void> deleteRichiesta(@PathVariable Long requestId) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public List<ApiResponse> getDati() {
        ApiResponse response1 = new ApiResponse();
        response1.setCreationTime(new Date());
        response1.setProgramma("1");
        response1.setEsclusioni(response1.getEsclusioni());
        response1.setStatus("COMPLETED");
        response1.setLetturaParziale(true);
        response1.setRequestId(5);
        response1.setMessage("Lista delle richieste di caricamento - 1");

        ApiResponse response2 = new ApiResponse();
        response2.setCreationTime(new Date());
        response2.setProgramma("1");
        response2.setEsclusioni(response2.getEsclusioni());
        response2.setStatus("PENDING");
        response2.setLetturaParziale(false);
        response2.setRequestId(6);
        response2.setMessage("Lista delle richieste di caricamento - 2");

        ApiResponse response3 = new ApiResponse();
        response3.setCreationTime(new Date());
        response3.setProgramma("1");
        response3.setEsclusioni(response3.getEsclusioni());
        response3.setStatus("FAILED");
        response3.setLetturaParziale(true);
        response3.setRequestId(7);
        response3.setMessage("Lista delle richieste di caricamento - 3");

        return List.of(response1, response2, response3);
    }
}
