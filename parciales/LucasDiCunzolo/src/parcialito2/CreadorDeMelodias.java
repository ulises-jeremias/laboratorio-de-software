package parcialito2;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class CreadorDeMelodias<T> {
	public static List<String> crearNotasYDuraciones(Class<?> className, int cant) {
		List<String> melodias = new ArrayList<String>(cant); 
		try {
			className.getAnnotation(Melodia.class);
			Escala escala = null;
			Duracion duracion = null;
			for(Field field : className.getDeclaredFields()) {
				field.setAccessible(true);
				
				if (field.getAnnotation(Escala.class) != null) {
					escala = field.getAnnotation(Escala.class);
				}
				
				if (field.getAnnotation(Duracion.class) != null) {
					duracion = field.getAnnotation(Duracion.class);
				}
			}
			for(int i = 0; i < cant; i++) {
				melodias.add("(" + escala.value()[(int)(escala.value().length*Math.random())] + "," + duracion.value()[(int)(duracion.value().length*Math.random())] + ")");
			}
		} catch(NullPointerException e) {
			System.err.printf(e.getMessage());
		} catch(Exception e) {
			System.err.println(e.getMessage());
		}
		return melodias;
	}
}
