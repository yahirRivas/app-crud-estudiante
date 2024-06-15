package com.app.crud.estudiante.service;

import java.util.List;

import com.app.crud.estudiante.service.dto.EstudianteServiceDTO;

public interface EstudianteService {

	EstudianteServiceDTO obtenerEstudianteById(Integer id);

	List<EstudianteServiceDTO> obtenerEstudiantes();
	EstudianteServiceDTO crear(EstudianteServiceDTO estudiante);

	boolean eliminar(Integer id);
}
