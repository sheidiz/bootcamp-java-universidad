package org.app.service;

import java.util.List;

import ar.com.educacionit.bootcamp.Articulo;
import ar.com.educacionit.bootcamp.repository.BaseRepository;
import ar.com.educacionit.bootcamp.repository.ArticuloRepositoryImpl;


public class ArticuloServiceImpl extends AbstractEntidadBaseService<Articulo> implements ArticuloService {

	public ArticuloServiceImpl() {
		super(new ArticuloRepositoryImpl());
	}
	
	
}