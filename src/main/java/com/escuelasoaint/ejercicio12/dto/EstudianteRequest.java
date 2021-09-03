package com.escuelasoaint.ejercicio12.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Representa a los estudiantes a matricular")
public class EstudianteRequest {

	@ApiModelProperty(notes = "Nombre del estudiante", example = "Luis", required = true)
	private String nombre;
	
	@ApiModelProperty(notes = "Numero de identificación del estudiante", example = "0221710047", required = true)
	private String numeroIdentificion;
	
	@ApiModelProperty(notes = "Correo del estudiante", example = "jhernadezudc@gmail.com", required = true)
	private String correo;
	
	@ApiModelProperty(notes = "Edad del estudiante", example = "16", required = true)
	private int edad;
	
	//@ApiModelProperty(notes = "Estado del estudiante", example = "ACTIVO", required = true)
	//private boolean estado;
	
	private List<AcudienteRequest> acudiente;
	
}
