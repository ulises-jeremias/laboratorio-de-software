package practica7.ejercicio2;

public class Test2 {
	public int unMetodo() {
		int count = 0;
		try {
			System.out.println("Va a retornar 1");
			return ++count;
		} finally {
			System.out.println("Va a retornar 2");
			return ++count;
		}
	}

	public static void main(String[] args) {
		Test2 res = new Test2();
		System.out.println(res.unMetodo());
	}
}
