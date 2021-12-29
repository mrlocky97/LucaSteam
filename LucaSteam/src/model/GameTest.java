package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GameTest {

	@Test
	void testGetName() {
		Genre genre = null;
		Platform p = null;
		Game g = new Game("fifa", "1990", "microsoft", genre, p);
		
		assertEquals(g.getName(), "pepe");
	}

}
