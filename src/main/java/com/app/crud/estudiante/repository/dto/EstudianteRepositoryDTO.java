package com.app.crud.estudiante.repository.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstudianteRepositoryDTO {

	private Integer id;
	private String nombre;
	private String apellido;
	private String email;
	private String creditos;
	private String semestre;
	private String promedio;
}
