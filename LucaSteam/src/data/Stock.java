package data;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

import java.util.Iterator;
import java.util.List;

import model.CSVObject;
import model.Game;
import model.Genre;
import model.Platform;


/*
 * Aqui implementamos el interface de IStock pero aqui desarrollamos LOS METODOS, tienen cuerpo.
 */
public class Stock  implements IStock{

	private List<Game> items = loadList();

	
	private Game game;

	/**
	 * add Game object into collection
	 * 
	 * @param unique
	 * @param item   return: void
	 */
	
	public boolean addGame(Game item) { /// INTEGER DE KEY??????
		 
		if(gameExists(item) == true){
			return false;
		}
		items.add(item);
		return true;
	}

	/**
	 * remove Game object from collection
	 * 
	 * @param unique return: void
	 */
	//public void remove(Integer key) {

	//	items.remove(key);
	//}

	/**
	 * print Game objects
	 * 
	 * @param: none return: void
	 */
	@Override
	public void printGames() {
		Game game;
		if(!items.isEmpty()) {
			Iterator<Game> iterator = items.iterator();
			while(iterator.hasNext()){
				game = iterator.next();
				
				System.out.println("Name: " + game.getName() + " Platform: " + game.getPlatform() + " Publisher: "
						+ game.getPublisher() + " Year: " + game.getYear() + " Genre: " + game.getGenre());
			}
		}
			
		
	}

 /*
	public void search(String name, Platform platform) {

		Iterator<Entry<Integer, Game>> it = items.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<Integer, Game> pair = (Map.Entry<Integer, Game>) it.next();
			System.out.println(pair.getKey() + " = " + pair.getValue());
			if (pair.getValue().getPlatform().compareToIgnoreCase(platform.getPlatform()) == 0
					&& pair.getValue().getName().compareToIgnoreCase(name) == 0) {
				// remove o lo que sea
			}
		}

	}
*/
	/**
	 * print Publishers from Game object
	 * 
	 * @param: none return: void
	 */
	/*
	public void printPublishers() {
		items.forEach((k, v) -> {
			System.out.println("Publishers: " + v.getPublisher());
		});
	}
*/
	/**
	 * print games done in even years
	 * 
	 * @param: none return: void
	 */
	/*
	public void printYearsEven() {
		items.forEach((k, v) -> {
			if (v.getYear() % 2 == 0) {
				System.out.println("Publishers: " + v.getYear());
			}
		});
	}
	*/

	/**
	 * print games of the XX Century
	 * 
	 * @param: none return: void
	 */
	
	/*
	public void printXXcentury() {
		items.forEach((k, v) -> {
			if (v.getYear() >= 1901 && v.getYear() <= 2000) {
				System.out.println("key: " + k + " Name: " + v.getName() + " Platform: " + v.getPlatform()
						+ " Publisher: " + v.getPublisher() + " Year: " + v.getYear() + " Genre: " + v.getGenre());
			}
		});
	}
*/
	/**
	 * print games by Genre
	 * 
	 * @param genre return: void
	 */
	public void printByGenre(Genre genre) {
		/*
		items.forEach((k, v) -> {
			if (v.getGenre().compareToIgnoreCase(genre.getGenre()) == 0) {
				System.out.println("key: " + k + " Name: " + v.getName() + " Platform: " + v.getPlatform()
						+ " Publisher: " + v.getPublisher() + " Year: " + v.getYear() + " Genre: " + v.getGenre());
			}
		});
		*/
	}

	/**
	 * print by filter console Nintendo
	 * 
	 * @param platform return: void
	 */
	/*
	public void printByNintendo(String publisher) {
		items.forEach((k, v) -> {
			if (v.getPublisher().compareToIgnoreCase(publisher) == 0) {
				System.out.println("key: " + k + " Name: " + v.getName() + " Platform: " + v.getPlatform()
						+ " Publisher: " + v.getPublisher() + " Year: " + v.getYear() + " Genre: " + v.getGenre());
			}
		});
	}
*/
	/**
	 * if the collection is not empty
	 * 
	 * @param: none
	 * @return: boolean
	 */
	public boolean listEmpty() {
		if (items.isEmpty()) {
			return true;
		}
		return false;
	}

	/**
	 * if a Game object exists by value
	 * 
	 * @param game
	 * @return: boolean
	 */
	public boolean gameExists(Game item) {
		return items.contains(item);
	}



	/**
	 * Update Game Object
	 * 
	 * @param key
	 * @param item return: void
	 */
	/*
	public boolean updateGame(int key, Game old, Game young) {
		return items.replace(key, old, young);
	}
	*/

	// TEST
	/*
	public boolean counterNintendo() {
		int contPlatform = 0;
		int contPublisher = 0;
		items.forEach((k, v) -> {
			if (v.getPublisher().compareToIgnoreCase("nintendo") == 0) {
				contPublisher++;
			}

			if (v.getPlatform().compareToIgnoreCase("wii") == 0) {
				contPlatform++;
			}
		});
		if (contPlatform == contPublisher) {
			return true;
		}
		return false;
	}

	@Override
	public void printByNintendo(Platform platform) {
		// TODO Auto-generated method stub

	}
*/
	@Override
	public List<Game> loadList() {
		try {
			FileReader fl = new FileReader("./src/csv/vgsales.csv");
			CSVReader reader = new CSVReaderBuilder(fl).withSkipLines(1). //
					build();
			List<Game> lsGame = reader.readAll().stream().map(data -> {
				Game game = new Game();
				game.setName(data[1]);
				game.setPlatform(Platform.switchPlatform(data[2]));
				game.setYear(Integer.parseInt(data[3]));
				game.setGenre(Genre.switchPlatform(data[2]));
				game.setPublisher(data[5]);
				return game;
			}).collect(Collectors.toList());
			// si el cs tiene datos diferentes a los no preestablecidos esto devuelve null y probablemente reviente....
			for (Game game : lsGame) {
				System.out.println(game.getName());
			}
			return lsGame;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} catch (CsvException e) {
			e.printStackTrace();
			return null;
		}
	}


}
