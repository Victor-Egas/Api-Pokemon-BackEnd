package com.pokeApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pokeApi.model.Pokemon;
import com.pokeApi.service.IPokemonService;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {
	
	@Autowired
	private IPokemonService service;
	
	@GetMapping("/findAll")	public ResponseEntity<List<Pokemon>>findAllPokemon() throws Exception{
		List<Pokemon> lista=service.findAll();//EL HTTPRESPONSE ES PARA METER EL OBJETO DE RESPUESTA(LIST)
		return new ResponseEntity<List<Pokemon>>(lista , HttpStatus.OK);
	}

}
