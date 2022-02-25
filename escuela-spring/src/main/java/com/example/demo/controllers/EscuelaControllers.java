package com.example.demo.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.SalonModel;
import com.example.demo.services.SalonService;

@RestController
public class EscuelaControllers {
	private final SalonService salonService;
	
	public EscuelaControllers(@Autowired SalonService salonService) {
		this.salonService=salonService;
	}
	
	//metodo datos  de salon 
	@GetMapping("/salon")
	public ArrayList<SalonModel>obtenerDatos(){
		return salonService.obtenerDatos();
	}
	
	// Guardar datos en la tabla salon
	@PostMapping("/salon")
	public SalonModel guardarDatos(@RequestBody SalonModel salonModel) {
		return salonService.guardarDatos(salonModel);
	}
	//eleiminarDato
	@DeleteMapping(path="/salon/{id}") //localhost:9999/salon/1
	public boolean eliminarDato(@PathVariable("id") Integer id) {
		return salonService.eliminarDato(id);
	}
}
