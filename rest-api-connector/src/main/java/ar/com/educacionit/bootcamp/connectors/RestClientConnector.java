package ar.com.educacionit.bootcamp.connectors;

import java.util.List;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Invocation;
import jakarta.ws.rs.client.Invocation.Builder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

public class RestClientConnector<T> {

	private String url;
	private Class<T> type;

	public RestClientConnector(String url, Class<T> type) {
		this.url = url;
		this.type = type;
	}
	public Response getResponse() {
		Client client = ClientBuilder.newClient();

		WebTarget target = this.buildWebTarget(client);

		Invocation.Builder invocation = target.request(MediaType.APPLICATION_JSON);

		Response response = this.buildResponse(invocation); 

		if(response.getStatus() != Status.OK.getStatusCode()) {
			throw new RuntimeException (response.getStatusInfo().getReasonPhrase());
		}
		return response;
	}
	public T execute() {
		Response response = this.getResponse();
		
		/*GenericType<List<Categoria>> listType = new GenericType<List<Categoria>>() {};		
		List<Categoria> list = response.readEntity(listType);*/
		T responseDto = response.readEntity(this.type);

		return responseDto;
	}
	public List<T> executeArray() {

		Response response = this.getResponse();

		try {
			GenericType<List<T>> responseDto = new GenericType<List<T>>() {}; 

			return response.readEntity(responseDto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/*private T buildFromResponse(Response response) {
		try {
			return response.readEntity(this.type);
		} catch (Exception e) {
			//Object obj = this.type.getConstructor().newInstance();
			//GenericType<List<Categoria>> listType = new GenericType<List<Categoria>>() {};		
			//List<Categoria> list = response.readEntity(listType);
			e.printStackTrace();
		}
		return null;
	}
	private List<T> buildFromResponseArray(Response response) {
		try {
			GenericType<List<T>> listType = new GenericType<List<T>>() {}; 

			return response.readEntity(listType);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}*/

	private Response buildResponse(Builder invocation) {
		//asumo que las peticiones son GET
		return invocation.get();
	}

	private WebTarget buildWebTarget(Client client) {
		return client.target(url);
	}
}