package com.fabian.examen3.repos;

import com.fabian.examen3.domain.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipoRepo extends JpaRepository<Equipo, Integer> {
}
