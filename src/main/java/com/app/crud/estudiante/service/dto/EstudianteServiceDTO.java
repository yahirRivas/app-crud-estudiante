package com.app.crud.estudiante.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstudianteServiceDTO {

	private Integer id;
	private String nombre;
	private String apellido;
	private String email;
	private String creditos;
	private String semestre;
	private String promedio;
}
