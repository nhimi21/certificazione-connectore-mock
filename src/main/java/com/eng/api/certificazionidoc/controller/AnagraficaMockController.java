package com.eng.api.certificazionidoc.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Api(value = "/Anagrafica Mock", tags = "Anagrafica Mock")
@RestController
@RequestMapping("/certificazione-connector/richiesta-di-caricamento-anagrafica")
public class AnagraficaMockController {

    @ApiOperation(value = "(Asincrona) - Avvio di una nuova attività di caricamento dell'anagrafica.")
    @PostMapping
    public ResponseEntity<Map<String, String>> avviaCaricamento() {
        Map<String, String> response = new HashMap<>();
        response.put("creationTime", LocalDateTime.now().toString());
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @ApiOperation(value = "(Asincrona) - Cancella i dati di anagrafica")
    @DeleteMapping
    public ResponseEntity<Void> cancellaAnagrafica() {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}