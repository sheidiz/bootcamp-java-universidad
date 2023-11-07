package ar.com.educacionit.bootcamp.controllers;

import ar.com.educacionit.bootcamp.connectors.meli.CategoriaConnector;

/*import jakarta.servlet.http.HttpServlet;*/

public class CategoriaController /*extends HttpServlet*/ {
	public static void main(String[] args) {
		CategoriaConnector cat = new CategoriaConnector();
		String resultado = cat.execute();
		System.out.println(resultado);
	}
}
