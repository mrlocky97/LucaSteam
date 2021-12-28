package services;

import exceptions.StockExceptions;
import model.Game;

public interface ISuperServices {
	
	public boolean addGame();
    public boolean addGame(Game g);  
    //public boolean deleteGame() throws StockException, Exception;
    public void printGames();
    //public boolean amountGames() throws StockException, Exception;
    //public void saveFileCSV();
    public void loadList();
 
}
