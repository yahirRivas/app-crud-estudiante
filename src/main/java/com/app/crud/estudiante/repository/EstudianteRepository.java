package com.app.crud.estudiante.repository;

import java.util.List;

import com.app.crud.estudiante.repository.dto.EstudianteRepositoryDTO;

public interface EstudianteRepository {

	EstudianteRepositoryDTO obtenerEstudianteById(Integer id);

	List<EstudianteRepositoryDTO> obtenerEstudiantes();
	EstudianteRepositoryDTO crear(EstudianteRepositoryDTO estudiante);

	boolean eliminar(Integer id);
}
