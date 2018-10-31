package practica8.ejercicio3;

import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class Contenedor {
	private static int maxConnections = 5;
	
	public static void generarServicio(String className) {
		try {
			Class<?> servicio = Class.forName(className);
			Servidor servidor = servicio.getAnnotation(Servidor.class);
			setUpServidor(servidor, servicio);
		} catch (ClassNotFoundException e) {
            System.err.println("La clase cuyo nombre se recibió como argumento no existe.");
        } catch (NullPointerException e) {
            System.err.println("Se encontró un puntero a null. Esto significa que la clase cuyo nombre se recibió como argumento no posee la anotación @Configuracion.");
        }
	}
	
	private static void setUpServidor(Servidor config, Class<?> servicio) {
		try {
			HttpServer server = HttpServer.create(new InetSocketAddress(config.puerto()), maxConnections);
			server.createContext("/", new ServerHandler(config, servicio));
			server.setExecutor(Executors.newFixedThreadPool(maxConnections));
            server.start();
            System.out.println("Servidor escuchando en: " + server.getAddress());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static class ServerHandler implements HttpHandler {
		private Servidor servidor;
		private Class<?> servicio;
		
		public ServerHandler(Servidor servidor, Class<?> servicio) {
			this.servicio = servicio;
			this.servidor = servidor;
		}

		@Override
		public void handle(HttpExchange httpExchange) throws IOException {	
			String response = "";
			int code = 200;
			
			try {
				String file = servidor.archivo();
				String ipAddress = httpExchange.getLocalAddress().getHostName();
				
				FileWriter fileWriter = new FileWriter(file);
				PrintWriter printWriter = new PrintWriter(fileWriter);
				printWriter.println(new SimpleDateFormat("dd-MM-yyyy").format(new Date()) + " " + ipAddress);
				printWriter.close();
				
				List<Method> methods = getMethodsToInvoke(servicio);
				
				for (Method method : methods) {
					response += method.invoke(null);
				}
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				System.err.println("Hubo una excepción al invocar al método anotado con @Servicio. La causa parece ser: " + e.getCause());
                response = "Ha ocurrido un error en el servidor. Revise los logs para visualizarlo.";
                code = 500;
			} catch (IndexOutOfBoundsException e) {
                System.err.println("No había métodos anotados con @Servicio.");
                response = "Ha ocurrido un error en el servidor. Revise los logs para visualizarlo.";
                code = 500;
			} catch (Exception e) {
                System.err.println("Ha ocurrido un error en el server.");
                response = "Ha ocurrido un error en el servidor. Revise los logs para visualizarlo.";
                code = 500;
			}
			
			httpExchange.sendResponseHeaders(code, response.length());
            OutputStream os = httpExchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
		}
		
        private List<Method> getMethodsToInvoke(Class<?> servicio) throws IndexOutOfBoundsException {
            return Stream.of(servicio.getDeclaredMethods())
                    .filter(method -> method.isAnnotationPresent(Invocar.class))
                    .collect(Collectors.toList());
        }
		
	}
}
