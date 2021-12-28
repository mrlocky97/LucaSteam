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
public class Stock implements IStock {

	private HashMap<Integer, Game> items;

	public Stock() {
		items = new HashMap<>();
	}

	private Game game;

	/**
	 * add Game object into collection
	 * 
	 * @param unique
	 * @param item   return: void
	 */
	public boolean addGame(Integer key, Game item) { /// INTEGER DE KEY??????
		if (gameExists(key)) {
			System.out.println("Ya existe");
			return false;
		} else {
			items.put(key, item);
			return true;
		}
	}

	/**
	 * remove Game object from collection
	 * 
	 * @param unique return: void
	 */
	public void remove(Integer key) {

		items.remove(key);
	}

	/**
	 * print Game objects
	 * 
	 * @param: none return: void
	 */
	@Override
	public void printGames() {
		items.forEach((k, v) -> {
			System.out.println("key: " + k + " Name: " + v.getName() + " Platform: " + v.getPlatform() + " Publisher: "
					+ v.getPublisher() + " Year: " + v.getYear() + " Genre: " + v.getGenre());
		});
	}

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

	/**
	 * print Publishers from Game object
	 * 
	 * @param: none return: void
	 */
	public void printPublishers() {
		items.forEach((k, v) -> {
			System.out.println("Publishers: " + v.getPublisher());
		});
	}

	/**
	 * print games done in even years
	 * 
	 * @param: none return: void
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
	 * 
	 * @param: none return: void
	 */
	public void printXXcentury() {
		items.forEach((k, v) -> {
			if (v.getYear() >= 1901 && v.getYear() <= 2000) {
				System.out.println("key: " + k + " Name: " + v.getName() + " Platform: " + v.getPlatform()
						+ " Publisher: " + v.getPublisher() + " Year: " + v.getYear() + " Genre: " + v.getGenre());
			}
		});
	}

	/**
	 * print games by Genre
	 * 
	 * @param genre return: void
	 */
	public void printByGenre(Genre genre) {
		items.forEach((k, v) -> {
			if (v.getGenre().compareToIgnoreCase(genre.getGenre()) == 0) {
				System.out.println("key: " + k + " Name: " + v.getName() + " Platform: " + v.getPlatform()
						+ " Publisher: " + v.getPublisher() + " Year: " + v.getYear() + " Genre: " + v.getGenre());
			}
		});
	}

	/**
	 * print by filter console Nintendo
	 * 
	 * @param platform return: void
	 */
	public void printByNintendo(String publisher) {
		items.forEach((k, v) -> {
			if (v.getPublisher().compareToIgnoreCase(publisher) == 0) {
				System.out.println("key: " + k + " Name: " + v.getName() + " Platform: " + v.getPlatform()
						+ " Publisher: " + v.getPublisher() + " Year: " + v.getYear() + " Genre: " + v.getGenre());
			}
		});
	}

	/**
	 * if the collection is not empty
	 * 
	 * @param: none
	 * @return: boolean
	 */
	public boolean isBusy() {
		if (items.isEmpty()) {
			return false;
		}
		return true;
	}

	/**
	 * if a Game object exists by value
	 * 
	 * @param game
	 * @return: boolean
	 */
	public boolean gameExists(Game item) {
		return items.containsValue(item);
	}

	/**
	 * if a Game object exists by key
	 * 
	 * @param key
	 * @return: boolean
	 */
	public boolean gameExists(int key) {
		return items.containsKey(game);
	}

	/**
	 * Update Game Object
	 * 
	 * @param key
	 * @param item return: void
	 */
	public boolean updateGame(int key, Game old, Game young) {
		return items.replace(key, old, young);
	}

	// TEST
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

	@Override
	public List<CSVObject> loadList() {
		try {
			FileReader fl = new FileReader("./src/csv/vgsales.csv");
			CSVReader reader = new CSVReaderBuilder(fl).withSkipLines(1). //
					build();
			List<CSVObject> csv_objectList = reader.readAll().stream().map(data -> {
				CSVObject csvObject = new CSVObject();
				csvObject.setName(data[1]);
				csvObject.setPlatform(data[2]);
				csvObject.setYear(data[3]);
				csvObject.setGenre(data[4]);
				csvObject.setPublisher(data[5]);
				return csvObject;
			}).collect(Collectors.toList());
			return csv_objectList;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} catch (CsvException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
