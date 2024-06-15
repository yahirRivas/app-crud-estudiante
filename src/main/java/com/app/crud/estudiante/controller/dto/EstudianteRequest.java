package com.app.crud.estudiante.controller.dto;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstudianteRequest implements Serializable {
	
	private static final long serialVersionUID = -961102218677406762L;

	private Integer id;
	private String nombre;
	private String apellido;
	@Email
	private String email;
	private String creditos;
	private String semestre;
	private String promedio;
}
