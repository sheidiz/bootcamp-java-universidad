package org.app.service;

import java.util.Collection;

import ar.com.educacionit.bootcamp.repository.BaseRepository;

public abstract class AbstractEntidadBaseService<T> implements EntidadBaseService<T> {

	private BaseRepository<T> repository;

	public AbstractEntidadBaseService(BaseRepository repository) {
		this.repository = repository;
	}

	@Override
	public Collection<T> buscarTodos() {		
		return this.repository.findAll();
	}

}