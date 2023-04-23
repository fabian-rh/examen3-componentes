package com.fabian.examen3.controllers;

import com.fabian.examen3.domain.Jugador;
import com.fabian.examen3.services.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jugador")
public class JugadorController {

    @Autowired
    private JugadorService service;

    @PostMapping(path = "/create")
    public ResponseEntity create(@RequestBody Jugador j){
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(service.insertarJugador(j));
        }catch(Exception e){
            System.out.println(e);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping(path = "/actualizar")
    public ResponseEntity actualizar(@RequestParam int id,@RequestBody Jugador j){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(service.actualizarJugador(id, j));
        }catch(Exception e){
            System.out.println(e);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping(path = "/getAll")
    public List getAll(){
        return service.listarJugadores();
    }

    @GetMapping(path = "/getId")
    public ResponseEntity<Jugador> getById(@RequestParam int id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(service.jugadorxID(id));
        }catch(Exception e){
            System.out.println(e);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/borrar")
    public ResponseEntity borrarxID(@RequestParam int id){
        try{
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.borrarJugador(id));
        }catch(Exception e){
            System.out.println(e);
        }
        return ResponseEntity.notFound().build();
    }



}
