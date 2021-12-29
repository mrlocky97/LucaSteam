package model;

import utilidades.DataInput;

public class Game {
	private String name;
	private int year;  //CAMBIAR A STRING
	private String publisher;
	private Genre genre;
	private Platform platform;

	public Game() {
	}

	public Game(String name, int year, String publisher, Genre genre, Platform platform) {
		this.name = name;
		this.year = year;
		this.publisher = publisher;
		this.genre = genre;
		this.platform = platform;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public Platform getPlatform() {
		return platform;
	}

	public void setPlatform(Platform platform) {
		this.platform = platform;
	}

	public boolean newGame() {

		try {
			System.out.println("Escribe el Nombre del Juego");
			this.name = DataInput.writeLine();
			System.out.println("Escribe el Año");
			this.year = DataInput.writeNumber();
			// this.platform;
			// this.genre;
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}

	}

	@Override
	public String toString() {
		return "Game [name=" + name + ", year=" + year + ", publisher=" + publisher + ", genre=" + genre + ", platform="
				+ platform + "]";
	}

}
