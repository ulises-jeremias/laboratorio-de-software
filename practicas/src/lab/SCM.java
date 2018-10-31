package lab;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executors;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class SCM {
	private static int maxConnections = 10;
	private static int port = 8000;
	
	public static void iniciar() {
		try {
			HttpServer server;
			ArrayList<Pair<String, String>> pairs = (ArrayList<Pair<String, String>>) CreadorDeMelodias.crearNotasYDuraciones(MelodiaEnDo.class, 100);
			
			for (Pair<String, String> pair : pairs) System.out.printf("%s%s ", pair.getL(), pair.getR());
			
			server = HttpServer.create(new InetSocketAddress(port), maxConnections);
			server.createContext("/", new ServerHandler(pairs));
			server.setExecutor(Executors.newFixedThreadPool(maxConnections));
	        server.start();
	        
	        System.out.println("\n\nServidor escuchando en: " + server.getAddress());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("Ocurrió un error en el servidor");
			e.printStackTrace();
		}
	}
	
	public static class ServerHandler implements HttpHandler {
		private ArrayList<Pair<String, String>> pairs;
		
		public ServerHandler(ArrayList<Pair<String, String>> pairs) {
			this.pairs = pairs;
		}
		
		@Override
		public void handle(HttpExchange httpExchange) throws IOException {
			String response = "";
			int code = 200;
			
			try {
				Pair<String, String> pair = pairs.get((int) (Math.random() * (pairs.size() - 0)) + 0);
				
				response = pair.getL() + pair.getR();
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
	}
}
