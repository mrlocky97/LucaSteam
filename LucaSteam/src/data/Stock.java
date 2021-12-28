package data;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Iterator;

import model.Game;


/*
 * Aqui implementamos el interface de IStock pero aqui desarrollamos LOS METODOS, tienen cuerpo.
 */
public class Stock implements IStock{
	
	
	private HashMap<Integer, Game> items;

    public Stock() {
        items = new HashMap<>();
    }
	
	private Game game;

	/**
	 * add Game object into collection
	 * @param unique
	 * @param item
	 * return: void
	 */
	public void addGame(Integer key, Game item){
		if(!gameExists(key)) 
			items.put(key, item);
		else
			System.out.println("Ya existe");
	}
	
	/**
	 * remove Game object from collection
	 * @param unique
	 * return: void
	 */
	public void remove(Integer key){
		
		items.remove(key);
	}
	
	/**
	 *print Game objects
	 *@param: none
	 *return: void
	 */
	public void printGames() {
		items.forEach((k, v) -> {
            System.out.println("key: "        + k                 +
            		           " Name: "      + v.getName()       +
            				   " Platform: "  + v.getPlatform()   +
            		           " Publisher: " + v.getPublisher()  +
            	               " Year: " 	  + v.getYear()       + 
            	               " Genre: "     + v.getGenre());
        });
	}
	
	public void search(String name, Platform platform) {
		
		    Iterator<Entry<Integer, Game>> it = items.entrySet().iterator();
		    while (it.hasNext()) {
		        Map.Entry<Integer,Game> pair = (Map.Entry<Integer,Game>)it.next();
		        System.out.println(pair.getKey() + " = " + pair.getValue());
		        if (pair.getValue().getPlatform().compareToIgnoreCase(platform.getPlatform()) == 0 && 
		        		pair.getValue().getName().compareToIgnoreCase(name) == 0) {
		        	// remove o lo que sea
		        }
		    }
		
	}
	
	/**
	 * print Publishers from Game object
	 * @param: none
	 * return: void
	 */
	public void printPublishers() {
		items.forEach((k, v) -> {
			System.out.println("Publishers: " + v.getPublisher());
        });
	}
	
	/**
	 * print games done in even years 
	 * @param: none
	 * return: void
	 */
	public void printYearsEven() {
		items.forEach((k, v) -> {
			if (v.getYear() % 2 == 0) {
				System.out.println("Publishers: " + v.getYear());
			}
        });
	}
	
	/**
	 * print games of the XX Century
	 * @param: none
	 * return: void
	 */
	public void printXXcentury() {
		items.forEach((k, v) -> {
			if (v.getYear() >= 1901 && v.getYear() <= 2000) {
				 System.out.println("key: "               + k  +
      		           " Name: "      + v.getName()       +
      				   " Platform: "  + v.getPlatform()   +
      		           " Publisher: " + v.getPublisher()  +
      	               " Year: " 	  + v.getYear()       + 
      	               " Genre: "     + v.getGenre());
			}
        });
	}
	
	/**
	 * print games by Genre
	 * @param genre
	 * return: void
	 */
	public void printByGenre(Genre genre) {
		items.forEach((k, v) -> {
			if (v.getGenre().compareToIgnoreCase(genre.getGenre()) == 0) {
				 System.out.println("key: "               + k  +
      		           " Name: "      + v.getName()       +
      				   " Platform: "  + v.getPlatform()   +
      		           " Publisher: " + v.getPublisher()  +
      	               " Year: " 	  + v.getYear()       + 
      	               " Genre: "     + v.getGenre());
			}
        });
	}
	
	/**
	 * print by filter console Nintendo
	 * @param platform
	 * return: void
	 */
	public void printByNintendo(String publisher) {
		items.forEach((k, v) -> {
			if (v.getPublisher().compareToIgnoreCase(publisher) == 0) {
				 System.out.println("key: "               + k  +
      		           " Name: "      + v.getName()       +
      				   " Platform: "  + v.getPlatform()   +
      		           " Publisher: " + v.getPublisher()  +
      	               " Year: " 	  + v.getYear()       + 
      	               " Genre: "     + v.getGenre());
			}
        });
	}
	/**
	 * if the collection is not empty
	 * @param: none
	 * @return: boolean
	 */
	public boolean isBusy() {
		if(items.isEmpty()){
			return false;
		}
		return true;
	}
	
	/**
	 * if a Game object exists by value
	 * @param game
	 * @return: boolean
	 */
	public boolean gameExists(Game item) {
		return items.containsValue(item);
	}
	
	/**
	 * if a Game object exists by key
	 * @param key
	 * @return: boolean
	 */
	public boolean gameExists(int key) {
		return items.containsKey(game);
	}

	/**
	 * Update Game Object
	 * @param key
	 * @param item
	 * return: void
	 */
	public boolean updateGame(int key, Game old, Game young) {
		return items.replace(key, old, young);
	}
	
	//TEST
	public boolean counterNintendo() {
		int contPlatform = 0;
		int contPublisher = 0;
		items.forEach((k, v) -> {
			if (v.getPublisher().compareToIgnoreCase("nintendo") == 0) {
				contPublisher++;
			}	
				 
			if(v.getPlatform().compareToIgnoreCase("wii") == 0) {
				contPlatform++;
			}
        });
		if (contPlatform == contPublisher) {
			return true;
		}
		return false;
	}


}  
