package com.uteq.afiliacion.afiliacion.service;

import com.uteq.afiliacion.afiliacion.dto.ClienteDto;
import com.uteq.afiliacion.afiliacion.entity.Afiliacion;
import com.uteq.afiliacion.afiliacion.repository.AfiliacionRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@Service
public class AfiliacionService {

    private final AfiliacionRepository repository;
    private final RestTemplate restTemplate;

    public AfiliacionService(AfiliacionRepository repository, RestTemplate restTemplate) {
        this.repository = repository;
        this.restTemplate = restTemplate;
    }

    public Afiliacion afiliar(Long clienteId) {
        String url = "http://localhost:8080/api/clientes/" + clienteId;
        ClienteDto cliente = restTemplate.getForObject(url, ClienteDto.class);

        if (cliente == null) {
            throw new RuntimeException("Cliente no existe");
        }

        // VALIDACIÓN EDAD
        if (cliente.getEdad() < 18) {
            throw new RuntimeException("Cliente menor de edad");
        }

        // VALIDACIÓN CIUDAD
        String ciudad = cliente.getCiudad().toLowerCase();
        if (!ciudad.equals("quito") && !ciudad.equals("guayaquil")) {
            throw new RuntimeException("Ciudad no permitida");
        }

        // VALIDACIÓN CORREO
        String email = cliente.getEmail().toLowerCase();
        if (!(email.endsWith("@gmail.com") || email.endsWith("@outlook.com"))) {
            throw new RuntimeException("Dominio de correo no permitido");
        }

        Afiliacion afiliacion = new Afiliacion();
        afiliacion.setClienteId(clienteId);
        afiliacion.setFechaAfiliacion(LocalDate.now());
        afiliacion.setEstado("AFILIADO");

        return repository.save(afiliacion);
    }
}
