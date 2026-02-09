package com.uteq.afiliacion.afiliacion.controller;

import com.uteq.afiliacion.afiliacion.service.AfiliacionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/vista/afiliacion")
public class AfiliacionViewController {

    private final AfiliacionService afiliacionService;

    public AfiliacionViewController(AfiliacionService afiliacionService) {
        this.afiliacionService = afiliacionService;
    }

    @GetMapping
    public String vista() {
        return "afiliacion";
    }

    @PostMapping
    public String afiliar(@RequestParam Long clienteId, Model model) {
        var afiliacion = afiliacionService.afiliar(clienteId);
        model.addAttribute("afiliacion", afiliacion);
        return "afiliacion_resultado";
    }
}
