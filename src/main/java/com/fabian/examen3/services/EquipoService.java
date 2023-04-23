package com.fabian.examen3.services;

import com.fabian.examen3.domain.Equipo;
import com.fabian.examen3.domain.Jugador;
import com.fabian.examen3.repos.EquipoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipoService {

    @Autowired
    EquipoRepo repo;

    public int insertarEquipo(Equipo e){
        try{
            return repo.save(e).getId();
        }catch (Exception ex){
            System.out.println(ex);
        }
        return -1;
    }

    public List<Equipo> listarEquipos(){
        try{
            return repo.findAll();
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
}
