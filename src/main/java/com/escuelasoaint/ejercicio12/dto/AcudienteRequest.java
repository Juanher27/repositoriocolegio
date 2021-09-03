package com.escuelasoaint.ejercicio12.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Representa a lo acudientes de los estudiantes a matricular")
public class AcudienteRequest {
	
	@ApiModelProperty(notes = "Nombre del acudiente", example = "Carlos", required = true)
	private String nombre;
	
	@ApiModelProperty(notes = "Indica el tipo de relación con el estudiante", example = "Padre", required = true)
	private String parentesco;
	
	@ApiModelProperty(notes = "Telefono del acudiente", example = "3053112785", required = true)
	private Long telefono;
}
