package com.escuelasoaint.ejercicio12.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escuelasoaint.ejercicio12.dto.EstudianteRequest;
import com.escuelasoaint.ejercicio12.entities.Acudiente;
import com.escuelasoaint.ejercicio12.entities.Estudiante;
import com.escuelasoaint.ejercicio12.repository.EstudianteRepository;

@Service
public class EstudianteService {

	@Autowired
	private EstudianteRepository estudianteRepository;
	
	public boolean crearEstudiante(EstudianteRequest payload) {
		
		if(payload.getEdad() < 18) {
			
			Estudiante estudiante = new Estudiante();
			
			estudiante.setNombre(payload.getNombre());
			estudiante.setNumeroIdentidficacion(payload.getNumeroIdentificion());
			estudiante.setCorreo(payload.getCorreo());
			estudiante.setEdad(payload.getEdad());
			estudiante.setEstado(true);
			
			List<Acudiente> acudientes = payload.getAcudiente().stream()
					.map( acudiente -> Acudiente.builder()
							.nombreAcudiente(acudiente.getNombre())
							.parentesco(acudiente.getParentesco())
							.telefono(acudiente.getTelefono())
							.estudiante(estudiante).build()).collect(Collectors.toList());
			
			estudiante.setAcudientes(acudientes);
			
			estudianteRepository.save(estudiante);
			return true;
		}else {
			
			return false;
		}
	}
	
	public List<Estudiante> listarEstudiante() {
		List<Estudiante> listaEstudiante = estudianteRepository.findAll();
		return listaEstudiante;
	}
	
	public boolean eliminarEstudiante(Long id) {
		
		Estudiante estudiante = buscarEstudiante(id);
		
		if (estudianteRepository.existsById(id)) {
			
			estudiante.setEstado(false);
			estudianteRepository.save(estudiante);
			
			return true;
		} else {
			return false;
		}
	}
	
	public Estudiante buscarEstudiante(Long id) {
		Estudiante estudiante = estudianteRepository.findById(id).get(); 
		
		return estudiante;
	}
	
	public boolean modificarEstudiante(Long id, EstudianteRequest payload) {
		
		Estudiante estudiante = buscarEstudiante(id);
		
		if(estudianteRepository.existsById(id)) {
			
			estudiante.setNombre(payload.getNombre());
			estudiante.setNumeroIdentidficacion(payload.getNumeroIdentificion());
			estudiante.setCorreo(payload.getCorreo());
			estudiante.setEdad(payload.getEdad());
			
			List<Acudiente> acudientes = payload.getAcudiente().stream()
					.map( acudiente -> Acudiente.builder()
							.nombreAcudiente(acudiente.getNombre())
							.parentesco(acudiente.getParentesco())
							.telefono(acudiente.getTelefono())
							.estudiante(estudiante).build()).collect(Collectors.toList());
			
			estudiante.setAcudientes(acudientes);
			
			estudianteRepository.save(estudiante);
			return true;
		}else {
			return false;
		}
	}
	
	public Estudiante consultarPorEdadEstado(int edad, boolean estado) {
		return estudianteRepository.findByEdadAndEstado(edad, estado);
	}

	
}
