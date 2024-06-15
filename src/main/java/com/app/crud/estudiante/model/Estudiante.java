package com.app.crud.estudiante.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "ESTUDIANTE")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Estudiante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;
	
	@Column(name = "nombre", nullable = false)
	private String nombre;
	
	@Column(name = "apellido", nullable = false)
	private String apellido;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "creditos", nullable = false)
	private Integer creditos;
	
	@Column(name = "semestre", nullable = false)
	private Integer semestre;

	@Column(name = "promedio", nullable = false)
	private Integer promedio;

}
