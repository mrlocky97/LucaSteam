package data;

import java.io.FileReader;
import java.io.IOException;

import java.util.stream.Collectors;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

import java.util.Iterator;
import java.util.List;

import model.Game;
import model.Genre;
import model.Platform;

/*
 * Aqui implementamos el interface de IStock pero aqui desarrollamos LOS METODOS, tienen cuerpo.
 */
public class Stock implements IStock {

	private List<Game> items = loadList();

	private Game game;

	/**
	 * add Game object into collection
	 * 
	 * @param unique
	 * @param item   return: void
	 */

	public boolean addGame(Game item) { /// INTEGER DE KEY??????
		if (gameExists(item) == true) {
			return false;
		} else {
			this.items.add(item);
			return true;
		}
	}

	/**
	 * print Game objects
	 * 
	 * @param: none return: void
	 */
	@Override
	public void printGames() {
		Game game;
		if (!items.isEmpty()) {
			Iterator<Game> iterator = items.iterator();
			while (iterator.hasNext()) {
				game = iterator.next();
				try {
					System.out.println("Name: " + game.getName() + " Platform: " + game.getPlatform() + " Publisher: "
							+ game.getPublisher() + " Year: " + game.getYear() + " Genre: " + game.getGenre());
				} catch (NullPointerException e) {
					System.out.println("Name: " + game.getName() + " Platform: " + game.getPlatform() + " Publisher: "
							+ game.getPublisher() + " Year: " + game.getYear() + " Genre: " + "Role-playing");
				}
			}
		}
	}

	/**
	 * print games by Genre
	 * 
	 * @param genre return: void
	 */
	public void printByGenre(Genre genre) {
		Game game = new Game();
		if (!items.isEmpty()) {
			Iterator<Game> iterator = items.iterator();
			while (iterator.hasNext()) {
				game = iterator.next();
				try {
					if (game.getGenre().getGenre().compareToIgnoreCase(genre.getGenre()) == 0) {
						System.out.println("Name: " + game.getName() + " Platform: " + game.getPlatform()
								+ " Publisher: " + game.getPublisher() + " Year: " + game.getYear() + " Genre: "
								+ game.getGenre());
					}
				} catch (NullPointerException e) {
					System.out.println("Name: " + game.getName() + " Platform: " + game.getPlatform() + " Publisher: "
							+ game.getPublisher() + " Year: " + game.getYear() + " Genre: " + "Role-playing");
				}
			}
		}

	}

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
				game.setYear(data[3]);
				game.setGenre(Genre.switchPlatform(data[4]));
				game.setPublisher(data[5]);
				return game;
			}).collect(Collectors.toList());
			// si el cs tiene datos diferentes a los no preestablecidos esto devuelve null y
			// probablemente reviente....
//			for (Game game : lsGame) {
//				System.out.println(game.getGenre());
//			}
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
