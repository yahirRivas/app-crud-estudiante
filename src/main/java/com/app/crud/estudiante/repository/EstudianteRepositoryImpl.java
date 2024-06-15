package com.app.crud.estudiante.repository;

import java.util.List;

import com.app.crud.estudiante.model.Estudiante;
import com.app.crud.estudiante.repository.dto.EstudianteRepositoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.crud.estudiante.mapper.EstudianteMapper;

@Repository
public class EstudianteRepositoryImpl implements EstudianteRepository {

	@Autowired
	private EstudianteJpaRepository estudianteJpaRepository;
	
	@Autowired
	private EstudianteMapper estudianteMapper;

	@Override
	public EstudianteRepositoryDTO obtenerEstudianteById(Integer id) {
		return estudianteMapper.estudianteToEstudianteRepositoryDto(estudianteJpaRepository.getById(id));
	}

	@Override
	public List<EstudianteRepositoryDTO> obtenerEstudiantes() {
		return estudianteMapper.estudiantesToEstudianteRepositoryDtoList(estudianteJpaRepository.findAll());
	}

	@Override
	public EstudianteRepositoryDTO crear(EstudianteRepositoryDTO estudiante) {

		Estudiante estudianteEntity = estudianteJpaRepository.save(estudianteMapper.estudianteRepositoryDtoToEstudiante(estudiante));

		return estudianteMapper.estudianteToEstudianteRepositoryDto(estudianteEntity);
	}

	@Override
	public boolean eliminar(Integer id) {

		try {

			Estudiante estudianteEntity = estudianteJpaRepository.getById(id);

			estudianteJpaRepository.delete(estudianteEntity);

		} catch (Exception ex){
			return false;
		}

		return true;
	}
}
