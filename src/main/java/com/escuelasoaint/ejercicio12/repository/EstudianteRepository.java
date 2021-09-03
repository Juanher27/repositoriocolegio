package com.escuelasoaint.ejercicio12.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.escuelasoaint.ejercicio12.entities.Estudiante;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long>{

	public Estudiante findByEdadAndEstado(int edad, boolean estado);
	
}
