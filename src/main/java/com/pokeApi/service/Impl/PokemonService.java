package com.pokeApi.service.Impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.pokeApi.model.Datos;
import com.pokeApi.model.Pokemon;
import com.pokeApi.service.IPokemonService;

@Service
public class PokemonService implements IPokemonService {

	public List<Pokemon> findAll() {
		
		RestTemplate restTemplate = new RestTemplate();
		 HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

        ResponseEntity<Datos> response = restTemplate.exchange("https://pokeapi.co/api/v2/pokemon-species", HttpMethod.GET,entity,Datos.class);
		
        List<Pokemon> lista=	response.getBody().getResults();
		
        return lista;
	}

}
