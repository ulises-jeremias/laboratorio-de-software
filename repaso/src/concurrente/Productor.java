package concurrente;

public class Productor implements Runnable {
	private static Integer count = 0;
	private Container<String> container;
	
	public Productor(Container<String> container) {
		this.container = container;
	}
	
	public void run() {
		synchronized(Productor.count) {
			String producto = "some" + Productor.count++;
			container.put(producto);
		}
	}
}
