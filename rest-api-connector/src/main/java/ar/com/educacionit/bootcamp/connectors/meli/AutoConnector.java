package ar.com.educacionit.bootcamp.connectors.meli;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ar.com.educacionit.bootcamp.connectors.RestClientConnector;
import ar.com.educacionit.bootcamp.connectors.meli.dto.Categoria;
import jakarta.ws.rs.core.Response;

public class AutoConnector {
	RestClientConnector connector;
	@SuppressWarnings("unchecked")
	public AutoConnector() {
		this.connector = new RestClientConnector(
				"https://api.mercadolibre.com/sites/MLA/domain_discovery/search?limit=1&q=fiat%20uno", Categoria.class);

	}
	public String obtenerUno() {
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
