package concurrente;

import java.util.LinkedList;

public class Container<E> {
	private LinkedList<E> things;
	private int capacity = 10;
	
	public Container() {
		this.things = new LinkedList<E>();
	}
	
	public synchronized E get() {
		while (things.isEmpty()) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		E value = things.pollFirst();
		System.out.printf("Se retorna valor %s\n", value);
		notifyAll();
		return value;
	}
	
	public synchronized void put(E value) {
		while (things.size() == capacity) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		things.addLast(value);
		System.out.printf("Se almacena valor %s\n", value);
		notifyAll();
	}
}
