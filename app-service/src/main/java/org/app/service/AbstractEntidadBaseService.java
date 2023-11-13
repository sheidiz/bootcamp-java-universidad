package org.app.service;

import java.util.Collection;

import ar.com.educacionit.bootcamp.repository.BaseRepository;

public abstract class AbstractEntidadBaseService<T> implements EntidadBaseService<T> {

	protected BaseRepository<T> repository;

	public AbstractEntidadBaseService(BaseRepository<T> repository) {
		this.repository = repository;
	}

	@Override
	public Collection<T> buscarTodos() {		
		return this.repository.findAll();
	}
	
	@Override
	public T buscarPorId(Long id) {
		return this.repository.getById(id);
	}
	
	@Override
	public void eliminarPorId(Long id) {
		this.repository.delete(id);
	}

	@Override
	public void guardar(T entity) {
		this.repository.save(entity);
	}
	
	@Override
	public void actualizar(T entity) {
		this.repository.update(entity);
	}
}