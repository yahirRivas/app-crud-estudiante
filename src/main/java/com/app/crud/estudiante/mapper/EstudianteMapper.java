package com.app.crud.estudiante.mapper;

import java.util.List;

import com.app.crud.estudiante.controller.dto.EstudianteRequest;
import com.app.crud.estudiante.controller.dto.EstudianteResponse;
import com.app.crud.estudiante.model.Estudiante;
import com.app.crud.estudiante.repository.dto.EstudianteRepositoryDTO;
import com.app.crud.estudiante.service.dto.EstudianteServiceDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EstudianteMapper {
	
	EstudianteMapper INSTANCE = Mappers.getMapper(EstudianteMapper.class);
	
	List<EstudianteRepositoryDTO> estudiantesToEstudianteRepositoryDtoList(List<Estudiante> estudiantes);
	
	List<EstudianteServiceDTO> estudiantesToEstudianteServiceDtoList(List<EstudianteRepositoryDTO> estudiantes);
	
	List<EstudianteResponse> estudiantesToEstudianteResponseList(List<EstudianteServiceDTO> estudiantes);
	
	Estudiante estudianteRepositoryDtoToEstudiante(EstudianteRepositoryDTO estudianteRepositoryDTO);
	
	EstudianteRepositoryDTO estudianteToEstudianteRepositoryDto(Estudiante estudiante);
	
	EstudianteServiceDTO estudianteRepositoryDtoToEstudianteServiceDto(EstudianteRepositoryDTO estudianteRepositoryDTO);
	
	EstudianteRepositoryDTO estudianteServiceDtoToEstudianteRepositoryDto(EstudianteServiceDTO estudianteServiceDTO);
	
	EstudianteResponse estudianteServiceDtoToEstudianteResponse(EstudianteServiceDTO estudianteServiceDTO);
	
	EstudianteServiceDTO estudianteRequestToEstudianteServiceDto(EstudianteRequest estudianteRequest);
}
