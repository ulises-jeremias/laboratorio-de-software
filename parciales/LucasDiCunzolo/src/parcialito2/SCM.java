package parcialito2;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class SCM {
	private static int maxConnections = 10;
	private static int port = 8000;
	private static List<String> melodia;
	private static Executor executor = null;
	
	public static void iniciar() {
		try {
			HttpServer server = HttpServer.create(new InetSocketAddress(port), maxConnections);
			server.setExecutor(getExecutor());
			server.createContext("/", new ServerHandler());
            server.start();
			melodia = CreadorDeMelodias.crearNotasYDuraciones(MelodiaDePrueba.class, 100);
			System.out.printf("Mi executor es %s\n\n", server.getExecutor().toString());
			System.out.printf("Mi melodia es %s\n\n", melodia.toString());
            System.out.println("Servidor escuchando en: " + server.getAddress());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void setExecutor(Executor executor) {
		System.out.println("Cambio de executor");
		SCM.executor = executor; 
	}
	
	public static Executor getExecutor() {
		return executor == null ? Executors.newFixedThreadPool(maxConnections) : executor;
	}
	
	private static class ServerHandler implements HttpHandler {

		@Override
		public void handle(HttpExchange httpExchange) throws IOException {
			double rand = Math.random();
			String response = melodia.size() > 0 ? melodia.get((int) (7*rand)) : "Hubo un error al procesar su peticion";
			int code = melodia.size() > 0 ? 200 : 500;

			httpExchange.sendResponseHeaders(code, response.length());
			OutputStream os = httpExchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
		}
		
	}
}
