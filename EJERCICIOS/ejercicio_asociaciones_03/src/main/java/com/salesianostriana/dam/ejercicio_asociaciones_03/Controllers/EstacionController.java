package com.salesianostriana.dam.ejercicio_asociaciones_03.Controllers;

import com.salesianostriana.dam.ejercicio_asociaciones_03.services.EstacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estacion")
@RequiredArgsConstructor
public class EstacionController {

    private final EstacionService estaServ;






}
