package ar.com.educacionit.bootcamp.connectors.meli;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ar.com.educacionit.bootcamp.connectors.RestClientConnector;
import ar.com.educacionit.bootcamp.connectors.meli.dto.Categoria;
import jakarta.ws.rs.core.Response;

public class CategoriaConnector {
	RestClientConnector connector;
	@SuppressWarnings("unchecked")
	public CategoriaConnector(String url) {
		this.connector = new RestClientConnector(
				url, Categoria.class);

	}
	public List<Categoria> getCategorias() {
		List<Categoria> lista = connector.executeArray();
		
		return lista;
	}

}
