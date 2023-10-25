package org.app.service;

import java.util.Collection;

public interface EntidadBaseService<T> {
	public Collection<T> buscarTodos();
	public T buscarPorId(Long id);
	public void eliminarPorId(Long id);
	public void guardar(T entity);
	public void actualizar(T entity);
}