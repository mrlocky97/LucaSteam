package data;


import java.util.List;


import model.Game;
import model.Genre;

/*
 * Aqui incluimos los metodos vacios, ya que SOLO ES UN INTERFACE.
 */ 
public interface IStock {
	
	public boolean addGame(Game item);
	public void printGames();  
	public void printByGenre(Genre genre);
	public List<Game> loadList();
			//METER A UTILIDADES O DATAINPUT
    public boolean gameExists(Game item);
    		//I+d para ver si podemos convertir de LIST a COLLECTION y buscar mas eficientemente
}
