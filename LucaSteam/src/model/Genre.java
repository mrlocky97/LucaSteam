package model;
   
public enum Genre {
	
	PLATFORM("Platform"), SPORTS("Sports"), ROL("Role-Playing"), RACING("Racing"), 
	MISC("Misc"), ACTION("Action"), SHOOTER("Shooter"), PUZZLE("Puzzle"),
	SIMULATION("Simulation"), FIGHTING("Fighting"), STRATEGY("Strategy");
	
	
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
	     * this.Platform = Platform.switchGenre(Metodo para recoger int -> Datos.recogeInt());
	     * 
	     * */
	 
	 /*
	  * @param String
	  * 
	  * @return 
	  * 
	  * */
	    public static Genre switchPlatform(String val) {
	        if (Genre.values == null) {
	            Genre.values = Genre.values();
	            
	        }
	        
	        return Genre.values[val.length()];
	    }
	
	
	

}
	

