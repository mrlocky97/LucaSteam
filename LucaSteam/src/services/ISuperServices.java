package services;

import model.Game;

public interface ISuperServices {
	
	public boolean addGame();
    public boolean addGame(Game g);  
    //public boolean deleteGame() 
    public void printGames();
    //public boolean amountGames()
   
    public void loadList();
 
}
