package org.app.service;

import java.util.Collection;
import java.util.Optional;

public interface EntidadBaseService<T> {
	public Collection<T> buscarTodos();
	public Optional<T> buscarPorId(Long id);
	public void eliminarPorId(Long id);
	public void guardar(T entity);
	public void actualizar(T entity);
}