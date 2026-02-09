package com.uteq.afiliacion.afiliacion.controller;

import com.uteq.afiliacion.afiliacion.service.ClienteProxyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ui")
public class UiController {

    private final ClienteProxyService clienteProxyService;

    public UiController(ClienteProxyService clienteProxyService) {
        this.clienteProxyService = clienteProxyService;
    }

    @GetMapping("/clientes")
    public Object listarClientes() {
        return clienteProxyService.listarClientes();
    }
}
