package model;



public enum Platform {
	
	PS4("PS4"), X360("X 360"), PS("PS"), PS2("PS2"), PS3("PS3"), 
	SNES("SNES"), Wii("Wii"), WiiU("WiiU"), 
	NES("NES"), XONE("X One"), GB("GB"), DS("DS"), GBA("GBA"),
	N64("N64"), DS3("3DS"), PSP("PSP"), PC("PC"), GEN("GEN"), 
	GC("GC"), SAT("SAT"), XB("XB"), PSV("PSV");

	private String p;
	

	private Platform(String p) {
		this.p = p;
		
	}

	public String getPlatform() {
		return p;
	}
	
	/*
	 * this.platform = Platform.switchPlatform(Metodo recoger int ->Datos.recogeInt());
	 * En la clase Game metodo createGame
	 * 
	 * */
	
	/*
	  * @param String
	  * 
	  * @return 
	  * 
	  * */
    private static Platform[] values = null;

    public static Platform switchPlatform(String val) {
        if (Platform.values == null) {
            Platform.values = Platform.values();
        }
        
        return Platform.values[val.length()];
    }
	
    
	
}
