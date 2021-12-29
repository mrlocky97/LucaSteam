package utilidades;

import model.Genre;
import model.Platform;

public class ReadEnum {

	
	public static void readGenre() {
		for (Genre item : Genre.values()) {
			System.out.println(item);
		}
		
	}

	
	public static void readPlatform() {
		for (Platform item : Platform.values()) {
			System.out.print(item + " - ");
		}
		
	}
}
