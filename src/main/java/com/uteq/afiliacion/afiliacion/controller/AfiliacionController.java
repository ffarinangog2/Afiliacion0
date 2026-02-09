package com.uteq.afiliacion.afiliacion.controller;

import com.uteq.afiliacion.afiliacion.entity.Afiliacion;
import com.uteq.afiliacion.afiliacion.service.AfiliacionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/afiliaciones")
public class AfiliacionController {

    private final AfiliacionService service;

    public AfiliacionController(AfiliacionService service) {
        this.service = service;
    }

    @PostMapping("/{clienteId}")
    public Afiliacion afiliar(@PathVariable Long clienteId) {
        return service.afiliar(clienteId);
    }
}

