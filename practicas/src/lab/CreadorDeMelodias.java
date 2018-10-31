package lab;

import lab.annotations.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CreadorDeMelodias {
	public static <T> List<Pair<String, String>> crearNotasYDuraciones(Class<T> elClass, int cant) throws Exception {
		List<Pair<String, String>> pairs = new ArrayList<Pair<String, String>>();
		
		Field fieldNota = getFieldWithEscala(elClass);
		Field fieldDuracion = getFieldWithDuracion(elClass);
		
		if (fieldNota == null || fieldDuracion == null)
			throw new Exception();
		
		int n, m;
		
		String[] notas = fieldNota.getAnnotation(Escala.class).value();
		String[] duraciones = fieldDuracion.getAnnotation(Duracion.class).value();
		
		System.out.println("Cantidad de notas recuperadas: " + notas.length);
		System.out.println("Cantidad de duraciones recuperadas " + duraciones.length);
		
		for (int i = 0; i < cant; i++) {
			n = (int) (Math.random() * (notas.length - 0)) + 0;
			m = (int) (Math.random() * (duraciones.length - 0)) + 0;
			pairs.add(new Pair<String, String>(notas[n], duraciones[m]));
		}  
		
		return pairs;
	}
	
	private static <T> Field getFieldWithEscala(Class<T> elClass) throws IndexOutOfBoundsException {
        return Stream.of(elClass.getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(Escala.class))
                .collect(Collectors.toList())
                .get(0);
    }
	
	private static <T> Field getFieldWithDuracion(Class<T> elClass) throws IndexOutOfBoundsException {
        return Stream.of(elClass.getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(Duracion.class))
                .collect(Collectors.toList())
                .get(0);
    }
}
