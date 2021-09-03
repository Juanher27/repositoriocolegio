package com.escuelasoaint.ejercicio12.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "tbl_estudiante_detalle")
public class Acudiente {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private long id;
	
	@Column(name = "nombre_acudiente", length = 50)
	private String nombreAcudiente;
	
	@Column(name = "Parentesco", length = 50)
	private String parentesco;
	
	@Column(name = "telefono")
	private long telefono;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Estudiante estudiante;
}