package com.escuelasoaint.ejercicio12.dto;

import lombok.Data;

@Data
public class EstudianteResponse {

	private long id;
	private String nombre;
	private String numeroIdentidficacion;
	private String correo;
	private int edad;	
	private boolean estado;
}
