package com.escuelasoaint.ejercicio12.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.escuelasoaint.ejercicio12.dto.EstudianteRequest;
import com.escuelasoaint.ejercicio12.dto.EstudianteResponse;
import com.escuelasoaint.ejercicio12.entities.Estudiante;
import com.escuelasoaint.ejercicio12.service.EstudianteService;
import com.escuelasoaint.ejercicio12.util.EntidadToConverter;


import io.swagger.annotations.ApiOperation;

@RestController
public class EstudianteController {

	@Autowired
	private EstudianteService estudianteService;
	
	@Autowired
	private EntidadToConverter convertidor;
	
	@PostMapping(value = "Estudiante")
	@ApiOperation(value = "Crear estudiante", notes = "Crea un estudiante si este es menor a 18 años")
	public ResponseEntity<Boolean> crearEstudiante(@RequestBody EstudianteRequest payload) {
		
		boolean existe = estudianteService.crearEstudiante(payload);
		
		if(existe) {
			return new ResponseEntity<>(existe,HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>(existe,HttpStatus.NOT_FOUND);
		}
		
	}
	
	@GetMapping(value = "Estudiante")
	@ApiOperation(value = "Listar Estudiante", notes = "Lista todos los estudiantes listados")
	public ResponseEntity <List<EstudianteResponse>> listarEstudiantes(){
		
		List<Estudiante> listaEstudiante = estudianteService.listarEstudiante();
		return new ResponseEntity<>(convertidor.convertirEntidad(listaEstudiante), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "Estudiante/{id}")
	@ApiOperation(value = "Eliminar Estudiante", notes = "Cambia el estado del estudiante a inactivo")
	public ResponseEntity<Boolean> eliminarEstudiante(@PathVariable Long id){
		boolean existe = estudianteService.eliminarEstudiante(id);
		
		if(existe) {
			return new ResponseEntity<>(existe, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(existe, HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PostMapping(value = "estudiante/{id}")
	@ApiOperation(value = "Buscar estudiantes por ID", notes = "Hace un recorrido y muestra el dato por parametro ID")
	public ResponseEntity<Estudiante> buscarEstudiante(@PathVariable Long id){
		Estudiante estudiante = estudianteService.buscarEstudiante(id);
		return new ResponseEntity<>(estudiante,HttpStatus.OK);
	}
	
	@PutMapping(value = "estudiante/{id}")
	@ApiOperation(value = "Modificar estudiante", notes = "Hace un recorrido y modifica el dato por parametro ID")
	public ResponseEntity<Boolean> modificarEstudiante(@PathVariable Long id, @RequestBody EstudianteRequest payload){
		boolean existe = estudianteService.modificarEstudiante(id, payload);
		
		if(existe) {
			return new ResponseEntity<>(existe, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(existe, HttpStatus.NOT_FOUND);
		}
	}
	
	
	@PostMapping(value = "estudiante/{edad}/{estado}" )
	@ApiOperation(value = "Buscar estudiante por edad y estado", notes = "Busca al estudiante por parametros Edad y Estado")
	public ResponseEntity<Estudiante> buscarPorEdadYEstado(@PathVariable Integer edad, @PathVariable Boolean estado){
		Estudiante estudiante = estudianteService.consultarPorEdadEstado(edad, estado);
		return new ResponseEntity<>(estudiante, HttpStatus.OK);
	}
}
