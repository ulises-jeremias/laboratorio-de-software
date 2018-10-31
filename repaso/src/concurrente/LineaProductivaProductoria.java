package concurrente;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LineaProductivaProductoria {

	public static void main(String[] args) {
		Container<String> container = new Container<String>();
		ExecutorService exec = Executors.newFixedThreadPool(10);
		exec.execute(new Consumidor(container));
		for(int i = 0; i <= 10; i++) {
			exec.execute(new Productor(container));
		}
	}

}
