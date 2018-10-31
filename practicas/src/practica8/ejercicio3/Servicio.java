package practica8.ejercicio3;

@Servidor(direccion="127.0.0.1", puerto=8080, archivo="/tmp/archivo")
public class Servicio {
	
	@Invocar
	public static String getHeader() {
		return "<h1>Bienvenido guachin</h1>\n";
	}
	
	@Invocar
	public static String getHello() {
		return "<h2>Este es el servidor de prueba</h2>\n";
	}
	
	@Invocar
	public static String getInfo() {
		return "<h3>Practica 8 - Punto 3</h3>\n";
	}
}
