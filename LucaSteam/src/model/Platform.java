package model;

public enum Platform {

	PS4("PS4"), X360("X 360"), PS("PS"), PS2("PS2"), PS3("PS3"), SNES("SNES"), Wii("Wii"), WiiU("WiiU"), NES("NES"),
	XONE("X One"), GB("GB"), DS("DS"), GBA("GBA"), N64("N64"), DS3("3DS"), PSP("PSP"), PC("PC"), GEN("GEN"), GC("GC"),
	SAT("SAT"), XB("XB"), PSV("PSV");

	private String p;

	private Platform(String p) {
		this.p = p;

	}

	public String getPlatform() {
		return p;
	}

	/*
	 * this.platform = Platform.switchPlatform(Metodo recoger int
	 * ->Datos.recogeInt()); En la clase Game metodo createGame
	 * 
	 */

	/*
	 * @param String
	 * 
	 * @return
	 * 
	 */
	// Comprobar que no nos devuelve un null
	public static Platform switchPlatform(String val) {
		try {
			return Platform.valueOf(val);
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}
	
	public static boolean switchPlatform2(String val) {
		boolean isNum = false;
		try {
			if (Platform.valueOf(val.toUpperCase())!= null) {
				isNum = true;
			}
			return isNum;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Introduce uno de los valores especificos.");
			e.getMessage();
			return false;
		}
	}

}
