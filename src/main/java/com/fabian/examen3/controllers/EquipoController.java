package com.fabian.examen3.controllers;

import com.fabian.examen3.domain.Equipo;
import com.fabian.examen3.domain.Jugador;
import com.fabian.examen3.services.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipo")
public class EquipoController {

    @Autowired
    private EquipoService service;

    @PostMapping(path = "/create")
    public ResponseEntity create(@RequestBody Equipo eq){
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(service.insertarEquipo(eq));
        }catch(Exception e){
            System.out.println(e);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping(path = "/getAll")
    public List getAll(){
        return service.listarEquipos();
    }
}
