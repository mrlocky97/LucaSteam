package model;

public enum Genre {

	PLATFORM("Platform"), SPORTS("Sports"), ROL("Role-Playing"), RACING("Racing"), MISC("Misc"), ACTION("Action"),
	SHOOTER("Shooter"), PUZZLE("Puzzle"), SIMULATION("Simulation"), FIGHTING("Fighting"), STRATEGY("Strategy");

	private String g;

	private Genre(String g) {
		this.g = g;

	}

	public String getGenre() {
		return g;
	}

	private static Genre[] values = null;

	/*
	 * Esto va dentro de la clase game en metodo createGame
	 * 
	 * this.Platform = Platform.switchGenre(Metodo para recoger int ->
	 * Datos.recogeInt());
	 * 
	 */

	/*
	 * @param String
	 * 
	 * @return
	 * 
	 */

	// Comprobar que no nos devuelve un null
	public static Genre switchPlatform(String val) {
		try {
			return Genre.valueOf(val.toUpperCase());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Error: El valor no existe....");
			e.getMessage();
			return null;
		}
	}
	
	public static boolean switchPlatform2(String val) {
		boolean isNum = false;
		try {
			if (Genre.valueOf(val.toUpperCase())!= null) {
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
