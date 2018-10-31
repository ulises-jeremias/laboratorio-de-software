package practica8.ejercicio3;

@Servidor(direccion="127.0.0.1", puerto=8080, archivo="/tmp/archivo")
public class Servicio {
	
	@Invocar
	public static String getLogin() {
		return "Hola wacho";
	}
}
