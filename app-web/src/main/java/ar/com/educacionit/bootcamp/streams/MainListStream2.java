package ar.com.educacionit.bootcamp.streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainListStream2 {

	public static void main(String[] args) {
		List<Integer> valores = List.of(5, 7, 9, 8, 15, 18, 6, 25, 78);
		
		/* Operaciones Lambdas:
		 * intermedias -> map filter peek
		 * terminal ->collect count max reduce
		*/
		var filtered = valores.stream()
				.map(v -> v * 1) 
				.peek(v -> System.out.println(v)) /*ver sin modificar el dato dentro del stream*/
				.filter(v -> v % 2 == 0)
				.filter(v -> v > 6)
				.collect(Collectors.toList());

		//reducitr a una suma todos los valores
		
		var suma = filtered.stream()
				.reduce(0, (subtotal, current) -> subtotal + current);

	}

}
