package services;

import exceptions.StockExceptions;
import model.Game;

public interface ISuperServices {
	
	public boolean AddGame() throws StockException;
    public boolean AddGame(Game g) throws StockException;  
    public boolean deleteGame() throws StockException, Exception;
    public void PrintGames();
    public boolean AmountGames() throws StockException, Exception;
    public void ChargerFileCVS();
    public void SaveFileCSV();
    
 
}
