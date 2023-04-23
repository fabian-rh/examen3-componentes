package com.fabian.examen3.repos;

import com.fabian.examen3.domain.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JugadorRepo extends JpaRepository<Jugador, Integer> {


}
