package data;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import model.Game;
import model.Genre;
import model.Platform;
import utilidades.DataInput;

class StockTest {

	@Test
	void testAddGame() {
		Genre genre;
		Platform p;

		String genero = "microsoft";
		genre = Genre.switchPlatform(genero);

		String plataform = "PS4";
		p = Platform.switchPlatform(plataform);

		Game g = new Game("fifa", "1990", "microsoft", genre, p);
		Stock s = new Stock();
		boolean result = true;
		assertEquals(result, s.addGame(g));
	}

	@Test
	void testAddGame2() {
		Genre genre;
		Platform p;

		String genero = "microsoft";
		genre = Genre.switchPlatform(genero);

		String plataform = "PS4";
		p = Platform.switchPlatform(plataform);

		Game g = new Game();
		g.setGenre(genre);
		Stock s = new Stock();
		boolean result = true;
		assertEquals(result, s.addGame(g));
	}
	

	@Test
	void testListEmpty() {
		Stock t = new Stock();
		assertEquals(false, t.listEmpty());
	}
// cuando ejecutamos este test pasa la prueba pero salta el catch en enum tipe
	
	@Test
	void testGameExists() {
		Stock t = new Stock();
		Genre genre = null;
		Platform p = null;
		Game g = new Game("fifa", "1990", "microsoft", genre, p);
		assertEquals(false, t.gameExists(g));
	}
	
	@Test
	void testLoadList() {
		Stock t = new Stock();
		List<String> ls = new ArrayList<>();
		ls.add("hola pepe");
		assertEquals(ls, t.loadList());
	}
	
}
