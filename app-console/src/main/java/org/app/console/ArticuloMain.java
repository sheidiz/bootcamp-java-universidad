package org.app.console;


import java.util.Collection;
import java.util.List;

import org.app.service.ArticuloService;
import org.app.service.ServiceLocator;

import ar.com.educacionit.bootcamp.Articulo;

public class ArticuloMain {

	public static void main(String[] args) {

		ArticuloService service = (ArticuloService )ServiceLocator.getService(ArticuloService.class);
		//Articulo entity = new Articulo(1L, 9789502417707L, 472, "ESPAÑOL", LocalDate.of(2023, 9, 1));
		//service.guardar(entity);
		Collection<Articulo> articulos = service.buscarTodos();
		System.out.println(articulos);
	}

}