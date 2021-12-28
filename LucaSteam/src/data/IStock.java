package data;


import java.util.List;

import model.CSVObject;
import model.Game;
import model.Genre;
import model.Platform;

/*
 * Aqui incluimos los metodos vacios, ya que SOLO ES UN INTERFACE.
 */ 
public interface IStock {
	
	public boolean addGame(Integer key, Game item) /*throws StockException*/;   
	public void remove(Integer key) /*throws StockException*/;
	public void printGames();  
	public void printPublishers();
	public void printYearsEven();
	public void printXXcentury();
	public void printByGenre(Genre genre);
	public void printByNintendo(Platform platform);
	public List<CSVObject> loadList();// caga de csv a lista
	public boolean isBusy();
    public boolean gameExists(Game item);
    public boolean gameExists(int key);    
    
    //public void serializarStock(String fichero);
    //public void deSerializarStock(String fichero);
    
    //public void CasosDePrueba();

}
