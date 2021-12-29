package utilidades;

import java.util.Scanner;

public class DataInput {

	public DataInput() {
		
	}
	
	@SuppressWarnings("resource")
	public static String writeLine() {
		String data= new Scanner(System.in).nextLine();
		return data;
	}
	
	@SuppressWarnings("resource")
	public static int writeNumber() {
		
		int year = new Scanner(System.in).nextInt();
		return year;
}
}
