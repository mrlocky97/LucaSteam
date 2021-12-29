package model;

import utilidades.DataInput;
import utilidades.ReadEnum;

public class Game {
	private String name;
	private String year; // CAMBIAR A STRING
	private String publisher;
	private Genre genre;
	private Platform platform;

	public Game() {
	}

	public Game(String name, String year, String publisher, Genre genre, Platform platform) {
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

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
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
			this.year = DataInput.writeLine();
			System.out.println("Escribe el Publisher");
			this.publisher = DataInput.writeLine();
			System.out.println("Debes elegir un Genero de la lista");
			ReadEnum.readGenre();
			System.out.println("Escribe el Genero Elegido");

			boolean rompeBucle = false;
			do {
				String genero = DataInput.writeLine();
				if (Genre.switchPlatform2(genero)) {
					rompeBucle = true;
					this.genre = Genre.switchPlatform(genero);
				}
			} while (!rompeBucle);

			System.out.println("Debes elegir una plataforma de la lista");
			ReadEnum.readPlatform();
			System.out.println("Escribe la plataforma Elegido");
			boolean rompeBucle2 = false;
			do {
				String genero = DataInput.writeLine();
				if (Platform.switchPlatform2(genero)) {
					rompeBucle2 = true;
					this.platform = Platform.switchPlatform(DataInput.writeLine());
				}// HAY QUE INTRODUCIR 2 VECES EL VALOR PARA QUE FUNCIONE
			} while (!rompeBucle2);

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
