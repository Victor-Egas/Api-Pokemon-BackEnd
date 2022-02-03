package com.pokeApi.service;

import java.util.List;

import com.pokeApi.model.Pokemon;

public interface IPokemonService {

	public List<Pokemon> findAll() throws Exception;
}
