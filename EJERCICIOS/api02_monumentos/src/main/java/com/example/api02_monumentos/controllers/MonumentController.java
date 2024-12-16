package com.example.api02_monumentos.controllers;

import com.example.api02_monumentos.models.Monument;
import com.example.api02_monumentos.services.MonumentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/monument")
@Tag(name = "Monumento", description = "Controlador de Monumentos, para poder realizar peticiones.")
public class MonumentController {

    @Autowired
    private MonumentService monuServ;


    @Operation(summary = "Obtiene todos los monumentos y también filtra")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Se han encontrado monumentos",
                    content = {
                            @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema()),
                            examples = {@ExampleObject(
                                    value = """
                                            [
                                                {
                                                    "id": 1,
                                                    "countryCode": "ES",
                                                    "countryName": "España",
                                                    "cityName": "Bilbao",
                                                    "name": "Puppy",
                                                    "longitude": "2°55′31″ O",
                                                    "latitude": "43°15′45″ N",
                                                    "description": "Perrito muy alegre hecho de flores.",
                                                    "image": "https://media.tacdn.com/media/attractions-splice-spp-674x446/0b/27/a5/f3.jpg"
                                                }
                                            ]
                                            """
                            )}
                    )}),
            @ApiResponse(responseCode = "404",
                    description = "No se ha encontrado ningún monumento",
                    content = @Content),
    })
    @GetMapping("/list")
    public List<Monument> getAllMonuments(
            @RequestParam(required = false, value = "countryCode", defaultValue = "") String countryCode,
            @RequestParam(required = false, value = "sort", defaultValue = "no") String sortDirection
    ) {
        return monuServ.query(countryCode, sortDirection);
    }

    @Operation(summary = "Obtiene un monumento por ID")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Se ha encontrado el monumento",
                    content = {
                            @Content(mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema()),
                                    examples = {@ExampleObject(
                                            value = """
                                            {
                                                "id": 1,
                                                "countryCode": "ES",
                                                "countryName": "España",
                                                "cityName": "Bilbao",
                                                "name": "Puppy",
                                                "longitude": "2°55′31″ O",
                                                "latitude": "43°15′45″ N",
                                                "description": "Perrito muy alegre hecho de flores.",
                                                "image": "https://media.tacdn.com/media/attractions-splice-spp-674x446/0b/27/a5/f3.jpg"
                                            }
                                            """
                                    )}
                            )}),
            @ApiResponse(responseCode = "404",
                    description = "No se ha encontrado ningún monumento con el ID introducido",
                    content = @Content),
    })
    @GetMapping("/{id}")
    public Monument getMonumentById(@PathVariable long id) {
        return monuServ.getMonument(id);
    }

    @Operation(summary = "Crea un monumento")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Se ha creado el producto",
                    content = {
                            @Content(mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema()),
                                    examples = {@ExampleObject(
                                            value = """
                                            {
                                                "countryCode": "ES",
                                                "countryName": "España",
                                                "cityName": "Bilbao",
                                                "name": "Puppy",
                                                "longitude": "2°55′31″ O",
                                                "latitude": "43°15′45″ N",
                                                "description": "Perrito muy alegre hecho de flores.",
                                                "image": "https://media.tacdn.com/media/attractions-splice-spp-674x446/0b/27/a5/f3.jpg"
                                            }
                                            """
                                    )}
                            )}),
            @ApiResponse(responseCode = "400",
                    description = "No se ha podido agregar el monumento",
                    content = @Content),
    })
    @PostMapping
    public ResponseEntity<Monument> createMonument(@RequestBody Monument m) {
        return ResponseEntity.status(HttpStatus.CREATED).body(monuServ.addMonument(m));
    }

    @Operation(summary = "Edita un monumento")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Se ha editado el monumento",
                    content = {
                            @Content(mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema()),
                                    examples = {@ExampleObject(
                                            value = """
                                            {
                                                "id": 1,
                                                "countryCode": "ES",
                                                "countryName": "España",
                                                "cityName": "Bilbao",
                                                "name": "Puppy",
                                                "longitude": "2°55′31″ O",
                                                "latitude": "43°15′45″ N",
                                                "description": "Perrito muy alegre hecho de flores.",
                                                "image": "https://media.tacdn.com/media/attractions-splice-spp-674x446/0b/27/a5/f3.jpg"
                                            }
                                            """
                                    )}
                            )}),
            @ApiResponse(responseCode = "400",
                    description = "No se ha podido editar el producto",
                    content = @Content),
    })
    @PutMapping("/{id}")
    public Monument editMonument(@RequestBody Monument m, @PathVariable long id) {
        return monuServ.edit(id,m);
    }

    @Operation(summary = "Obtiene un monumento por ID")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "204",
                    description = "Se ha borrado el monumento",
                    content = {
                            @Content(mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema())
                            )}
            )
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Monument> deleteMonumentById(@PathVariable long id) {
        monuServ.delete(id);
        return ResponseEntity.noContent().build();
    }
}
