package utilidades;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DataInputTest {

	@Test
	void testWriteLine() {
		DataInput d = new DataInput();
		String p = "hola";
		System.out.println("escribe una cadena:");
		String cadena = d.writeLine();
		assertEquals(p, cadena);
	}
	

	@Test
	void testWriteLine2() {
		DataInput d = new DataInput();
		String p = "hola";
		System.out.println("escribe una cadena:");
		String cadena = d.writeLine();
		assertEquals(p, cadena);
	}

	@Test
	void testWriteNumber() {
		DataInput d = new DataInput();
		int p = 10;
		System.out.println("escribe un numero:");
		int num = d.writeNumber();
		assertEquals(p, num);
	}
	
	@Test
	void testWriteNumber2() {
		DataInput d = new DataInput();
		double p = 10.5d;
		System.out.println("escribe un numero:");
		int num = d.writeNumber();
		assertEquals(p, num);
	}

}
