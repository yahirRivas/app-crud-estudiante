package com.app.crud.estudiante.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.app.crud.estudiante.model.Estudiante;

public interface EstudianteJpaRepository extends JpaRepository<Estudiante, Integer> {

}
