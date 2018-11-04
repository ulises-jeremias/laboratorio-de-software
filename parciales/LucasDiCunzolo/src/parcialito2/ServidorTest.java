package parcialito2;

import java.util.concurrent.Executors;

public class ServidorTest {

	public static void main(String[] args) {
		// Se puede cambiar el executor por defecto.
		// SCM.setExecutor(Executors.newFixedThreadPool(2));
		SCM.iniciar();
	}

}
