package com.app.crud.estudiante.service;

import java.util.List;

import com.app.crud.estudiante.mapper.EstudianteMapper;
import com.app.crud.estudiante.repository.EstudianteRepository;
import com.app.crud.estudiante.service.dto.EstudianteServiceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstudianteServiceImpl implements EstudianteService {

	@Autowired
	private EstudianteRepository estudianteRepository;
	
	@Autowired
	private EstudianteMapper estudianteMapper;


	@Override
	public EstudianteServiceDTO obtenerEstudianteById(Integer id) {
		return estudianteMapper.estudianteRepositoryDtoToEstudianteServiceDto(estudianteRepository.obtenerEstudianteById(id));
	}

	@Override
	public List<EstudianteServiceDTO> obtenerEstudiantes() {
		return estudianteMapper.estudiantesToEstudianteServiceDtoList(estudianteRepository.obtenerEstudiantes());
	}

	@Override
	public EstudianteServiceDTO crear(EstudianteServiceDTO estudiante) {
		return estudianteMapper.estudianteRepositoryDtoToEstudianteServiceDto(
				estudianteRepository.crear(estudianteMapper.estudianteServiceDtoToEstudianteRepositoryDto(estudiante)));
	}

	@Override
	public boolean eliminar(Integer id) {
		return estudianteRepository.eliminar(id);
	}
}
