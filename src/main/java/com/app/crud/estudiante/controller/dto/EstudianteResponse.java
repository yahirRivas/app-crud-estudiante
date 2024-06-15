package com.app.crud.estudiante.controller.dto;

import java.io.Serializable;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstudianteResponse implements Serializable {
	
	private static final long serialVersionUID = 2300089273872861549L;

	private Integer id;
	private String nombre;
	private String apellido;
	private String email;
	private String creditos;
	private String semestre;
	private String promedio;
}
