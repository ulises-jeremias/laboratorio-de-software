package concurrente;

import java.util.ArrayList;
import java.util.List;

public class Consumidor implements Runnable{
	private Container<String> container;
	private List<String> products;

	public Consumidor(Container<String> container) {
		this.container = container;
		this.products = new ArrayList<String>();
	}
	
	public void run() {
		int count = 0;
		while(true) {
			String product = container.get();
			products.add(product);
			count++;
			if (count == 10) {
				break;
			}
		}
	}
}
