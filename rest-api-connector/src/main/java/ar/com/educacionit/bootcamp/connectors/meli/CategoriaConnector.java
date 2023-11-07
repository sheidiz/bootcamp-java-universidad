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
	public CategoriaConnector() {
		this.connector = new RestClientConnector(
				"https://api.mercadolibre.com/sites/MLA/categories", Categoria.class);

	}
	public String execute() {
		List<Categoria> lista = connector.executeArray();
		ObjectMapper mapper = new ObjectMapper(); 
		String json = null;
		try {
			json = mapper.writeValueAsString(lista);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;
	}

}
