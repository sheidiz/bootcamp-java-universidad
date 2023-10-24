package ar.com.educacionit.bootcamp.repository;

import java.util.Collection;

import ar.com.educacionit.bootcamp.EntidadB;

public interface EntidadBRepository {
	public void save(EntidadB entidad);//guardar (db, archivo, memoria, etc) 
	public void delete(String id);//eliminar (db, archivo, memoria, etc) 
	public void update(EntidadB entidad);//actualizar (db, archivo, memoria, etc) 
	public EntidadB getById(String id);//actualizar (db, archivo, memoria, etc)
	public Collection<EntidadB> findAll();
	//agrego aca lo que necesito
}