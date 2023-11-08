package ar.com.educacionit.bootcamp.controllers;

import ar.com.educacionit.bootcamp.connectors.meli.CategoriaConnector;
import ar.com.educacionit.bootcamp.connectors.meli.dto.Auto;
import ar.com.educacionit.bootcamp.connectors.meli.dto.Categoria;

import java.util.List;

import ar.com.educacionit.bootcamp.connectors.meli.AutoConnector;

/*import jakarta.servlet.http.HttpServlet;*/

public class CategoriaController /*extends HttpServlet*/ {
	public static void main(String[] args) {
		CategoriaConnector cat = new CategoriaConnector("https://api.mercadolibre.com/sites/MLA/categories");
		List<Categoria> resultado = cat.getCategorias();
		System.out.println(resultado);
		
//		AutoConnector autitos = new AutoConnector();
//		String jsonAutos = autitos.obtenerUno();
//		System.out.println(jsonAutos);
	}
}
