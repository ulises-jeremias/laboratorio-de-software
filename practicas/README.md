# Practicas

* * *

## Practica 7

### Ejercicio 1

> Determine si el siguiente código es correcto. Si produce un error, observe de qué tipo es y soluciónelo.

```java
class Excepcion1 extends Exception {}
class Excepcion2 extends Exception1 {}

public class Test1 {
    public static void main(String[] args) {
        try {
            throw new Exception2();
        } catch(Excepcion1 e1) {
            System.out.println(“Se capturó la Excepción1”);
        } catch(Excepcion2 e2) {
            System.out.println(“Se capturó la Excepción2”);
        }
    }
}
```

El código tira el siguiente error `Unreachable catch block for Exception2. It is already handled by the catch block for Exception1`.

La forma de solucionarlo es invirtiendo las sentencias catch de la siguiente forma:

```java
class Excepcion1 extends Exception {}
class Excepcion2 extends Exception1 {}

public class Test1 {
    public static void main(String[] args) {
        try {
            throw new Exception2();
        } catch(Excepcion1 e2) {
            System.out.println(“Se capturó la Excepción2”);
        } catch(Excepcion2 e1) {
            System.out.println(“Se capturó la Excepción1”);
        }
    }
}
```

### Ejercicio 2

> - Ejecute el siguiente código. ¿Cuál es el resultado?. Elimine los comentarios y vuelva a ejecutarlo. ¿Cuál es el resultado?.

```java
public class Test2 {
	public int unMetodo() {
		// try {
			System.out.println("Va a retornar 1");
			return 1;
		// } finally {
			System.out.println("Va a retornar 2");
			return 2;
		// }
	}

	public static void main(String[] args) {
		Test2 res = new Test2();
		System.out.println(res.unMetodo());
	}
}
```

El código con los comentarios no ejecuta, dado que pide que se borren las lineas

```java
System.out.println("Va a retornar 2");
return 2;
```

del método `unMetodo`. Una vez removidos los comentarios, se ejecuta el bloque `try`, y posteriormente el bloque `finally`, dado que el mismo siempre se ejecuta. El resultado impreso se corresponde con el retorno dentro de este último bloque, por lo que el resultado es `2`.

La salida del programa es:

```
Va a retornar 1
Va a retornar 2
2
```

### Ejercicio 3

> Ejecute el siguiente código. ¿Cuál es la salida del programa?

```java
public class Test3 {
    public static void main(String[] args) {
        System.out.println("Test3");
        try {
            System.out.println("Primer try");
            try {
                throw new Exception();
            } finally {
                System.out.println("Finally del 2º try");
            }
        } catch (Exception e) {
            System.out.println("Se capturó la Excepción ex del 1º Primer try");
        } finally {
            System.out.println("Finally del 1º try");
        }
    }
}
```

La salida del programa es la siguiente:

```
Test3
Primer try
Finally del 2º try
Se capturó la Excepción ex del 1º Primer try
Finally del 1º try
```

#### Ejercicio 5

> Analice el siguiente código:

```java
public class Suma {
    public static void main(String[] args){
        int suma = 0;
        
        for(int i = 0; i <= args.length; i++) {
            suma += Integer.parseInt(args[i]);
        }

        System.out.print("La suma es:"+suma);
    }
}
```

La solución planteada para el caso de que se ingrese un string no válido es la siguiente:

```java
public class Suma {
	public static void main(String[] args) {
		int suma = 0;

		try {
			for (int i = 0; i < args.length; i++) {
				suma += Integer.parseInt(args[i]);
			}
		
		} catch (NumberFormatException e) {
			System.out.println("El argumento ingresado no es un número " + e.getMessage());
		}

		System.out.print("La suma es:" + suma);
	}
}
```
