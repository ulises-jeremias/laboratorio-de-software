package quintaentrega;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class Mapper {
	public static void findAttributes(Map<String,String> attributes, Serializable obj) {
		for (Field f : obj.getClass().getDeclaredFields()) {
			AlmacenarAtributo attr = f.getAnnotation(AlmacenarAtributo.class);
			if(attr != null) {
				try {
					f.setAccessible(true);
					String value = f.get(obj) != null ? f.get(obj).toString() : "null";
					attributes.put(f.getName(), value);
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void writeFile(Serializable obj) {
		Map<String,String> attributes = new HashMap<String,String>();
		findAttributes(attributes, obj);
		try {
			FileWriter fileWriter = new FileWriter(obj.getClass().getAnnotation(Archivo.class).name());
			PrintWriter printWriter = new PrintWriter(fileWriter);
			printWriter.println("<nombreClase>" + obj.getClass().getName() + "</nombreClase>");
			attributes
				.forEach((key, value) -> {
					printWriter.printf("<nombreAtributo>%s</nombreAtributo>\n", key);
					printWriter.printf("<nombreValor>%s</nombreValor>\n", value);
				});
			printWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		writeFile(new Mapped(2.5));
	}
}
