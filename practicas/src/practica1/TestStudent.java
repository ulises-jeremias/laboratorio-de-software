package practica1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestStudent {

	private Student students[];

	private String names[][];
	private Integer numbers[];
	private String strings[];
	
	@BeforeEach
	void setUp() throws Exception {
		students = new Student[5];
		names = new String[5][2];
		numbers = new Integer[5];
		strings = new String[5];

		for(int i = 0; i < 5; i++) {
			students[i] = new Student();
			names[i][0] = "Nombre" + i;
			names[i][1] = "Apellido" + i;
			numbers[i] = i * 5673;
			strings[i] = names[i][0] + ", " + names[i][1] + " : " + numbers[i];
		}
		for (int i = 0; i < 5; i++) {
			students[i].setFirstname(names[i][0]);
			students[i].setLastname(names[i][1]);
			students[i].setNumber(numbers[i]);
		}
	}

	@Test
	void testGetterAndSetters() {
		for (int i = 0; i < 5; i++) {
			assertEquals(students[i].getFirstname(), names[i][0]);
			assertEquals(students[i].getLastname(), names[i][1]);
			assertEquals(students[i].getNumber(), numbers[i]);
		}
	}
	
	@Test
	void testToString() {
		for (int i = 0; i < 5; i++) {
			assertEquals(students[i].toString(), strings[i]);
		}
	}
	
	@Test
	void testNotEquals() {
		assertNotEquals(students[1], students[2]);
		assertFalse(students[1].equals(students[2]));
	}
	

	@Test
	void testEquals() {
		students[2].setFirstname(students[1].getFirstname());
		students[2].setLastname(students[1].getLastname());
		students[2].setNumber(students[1].getNumber());
		assertNotEquals(students[1], students[2]);
		assertTrue(students[1].equals(students[2]));
	}
	
}
