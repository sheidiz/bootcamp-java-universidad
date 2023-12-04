package org.app.service;


import ar.com.educacionit.bootcamp.Articulo;
import ar.com.educacionit.bootcamp.repository.ArticuloRepositoryImpl;


public class ArticuloServiceImpl extends AbstractEntidadBaseService<Articulo> implements ArticuloService {

	public ArticuloServiceImpl() {
		super(new ArticuloRepositoryImpl());
	}
	@Override
	public Articulo buscarPorISBN(Long isbn) {		
		return ((ArticuloRepositoryImpl)this.repository).getByISBN(isbn);
	}
	
}