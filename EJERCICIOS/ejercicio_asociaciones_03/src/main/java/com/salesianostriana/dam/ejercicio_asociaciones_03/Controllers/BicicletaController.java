package com.salesianostriana.dam.ejercicio_asociaciones_03.Controllers;

import com.salesianostriana.dam.ejercicio_asociaciones_03.services.BicicletaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bicicleta")
@RequiredArgsConstructor
public class BicicletaController {

    private final BicicletaService biciServ;

}
