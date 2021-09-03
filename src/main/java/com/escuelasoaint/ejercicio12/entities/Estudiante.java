package com.escuelasoaint.ejercicio12.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_estudiante")
public class Estudiante {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private long id;
	
	@Column(name = "nombre_estudiante", length = 50)
	private String nombre;
	
	@Column(name = "numero_identificacion", length = 50)
	private String numeroIdentidficacion;
	
	@Column(name = "correo", length = 50)
	private String correo;
	
	@Column(name = "edad")
	private int edad;
	
	@Column(name = "estado")
	private boolean estado;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "estudiante")
	private List<Acudiente> acudientes;
	
}
