package utilidades;

import java.util.Scanner;

public class DataInput {

	public DataInput() {

	}

	public static String writeLine() {
		String data = "";
		boolean noestaVacio = false;
		while (!noestaVacio) {
			data = new Scanner(System.in).nextLine();
			if (data.trim().equals("")) {
				System.out.println("El elemento esta vacio");
			} else {
				noestaVacio = true;
			}
		}
		return data;
	}

	@SuppressWarnings("resource")
	public static int writeNumber() {
		int year = -1;
		boolean noesString = false;
		while (!noesString) {
			try {
				// TODO: handle exception
				System.out.println("Introduzca un num");
				int data = new Scanner(System.in).nextInt();
				noesString = true;
				return data;
			} catch (Exception e) {
				System.out.println("Eso no es un num");
			}
		}
		return year;
	}
}