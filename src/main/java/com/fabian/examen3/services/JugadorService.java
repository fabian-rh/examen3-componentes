package com.fabian.examen3.services;

import com.fabian.examen3.domain.Jugador;
import com.fabian.examen3.repos.JugadorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JugadorService {

    @Autowired
    JugadorRepo repo;

    public int insertarJugador(Jugador j){
        try{
            return repo.save(j).getId();
        }catch (Exception e){
            System.out.println(e);
        }
        return -1;
    }

    public List<Jugador> listarJugadores(){
        try{
            return repo.findAll();
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    public boolean actualizarJugador(int id, Jugador j){
        Optional<Jugador> j2 = repo.findById(id);
        if(j2.isPresent()){
            try{
                Jugador j3 = j2.get();
                j3.setNombre(j.getNombre());
                j3.setFechaNacimiento(j.getFechaNacimiento());
                j3.setPiernaDominante(j.getPiernaDominante());
                j3.setEstatura(j.getEstatura());
                j3.setPeso(j.getPeso());
                j3.setActivo(j.isActivo());
                repo.save(j3);
                return true;
            }catch (Exception e){
                System.out.println(e);
            }
        }
        return false;
    }

    public boolean borrarJugador(int id){
        try{
            Optional<Jugador> j2 = repo.findById(id);
            if(j2.isPresent()){
                repo.delete(j2.get());
                return true;
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return false;
    }

    public Jugador jugadorxID(int id){
        try{
            Optional<Jugador> j2 = repo.findById(id);
            if(j2.isPresent()){
                return j2.get();
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return null;
    }

}
