package com.uteq.afiliacion.afiliacion.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ClienteProxyService {

    private final RestTemplate restTemplate;

    public ClienteProxyService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Object listarClientes() {
        return restTemplate.getForObject("http://localhost:8080/api/clientes", Object.class);
    }
}
