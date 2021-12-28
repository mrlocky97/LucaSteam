package services;

import data.IStock;
import data.Stock;
import exceptions.StockExceptions;
import model.Game;
import utilidades.Datos;

public class SuperServices implements ISuperServices {
	
	private IStock stock = new Stock();
	
	/*
	*@return: Un Objeto de tipo Game
	*
	*/
	public boolean addGame() throws StockException {
        Game g = new Game();   
        return g.newGame();
    }
	
	/*
	*@param: Game g
	*
	*@return: Genera un codigo aleatorio (hash) para un objeto
	*
	*/
	
    public boolean addGame(Game g) throws StockException  {
        //Habria que decidir un algoritmo de cÃ³digos (una funciona Hash)
        return stock.addGame(g);  //////SE LE HA BORRADO EL KEY, PORQUE ERA UN INTEGER. Y ya no tiene integer nuestro Game.,.
    }
	
    /*
	*@return: Borra un Juego de la Lista llamando al metodo para borrar juego. Controla Excepciones de 
	* posible variable vacía.
	*/
	
	 public boolean deleteGame() throws StockException, Exception {
	        String name = Datos.ScanString("   Indica el nombre del Juego a Eliminar");

	        if (stock.existsGame(name)) {
	            stock.deleteGame(name);
	            System.out.println("   Juego eliminado");
	            return true;
	        } else {
	        	throw new StockException("No existe ese juego en el listado.");
	            //return false;
	        }
	    }
	 
	   /*
	    *@param: none
		*@return: Llama al metodo para Printear la lista de Juegos 
		*
		*/
	 
	 public void PrintGames() {
	        stock.PrintGames();
	    }
	 
	 	/*
	 	 * @param: void
		*@return: Llama a un metodo para contar la cantidad de juegos de un determinado editor.
		*
		*/
	 
	 public boolean AmountGames() throws StockException, Exception {
	        String publisher = Datos.recogeString(" Indica de que Editor quieres contar los Juegos ");
	        //Falta introdocir el switch para elegir el editor que queremos contar.
	        return stock.AmountGames(publisher);
	    }
	 
	 /*
	  * @param: none
	  * @return: Llama al metodo que carga el archivo CSV en una lista
	  * 
	  */
	 
	 public void ChargeFileCVS() {
	        //Por defecto
	        stock.ChargeStock("");//Añadir Ruta y cambiar nombre de llamada.
	    }
	 

	 /*
	  * @param: none
	  * @return: Llama al metodo que guarda la lista en un archivo CSV.
	  * 
	  */

	    public void saveFileCSV() {
	        //Por defecto
	        stock.SaveStock(""); //Añadir Ruta y cambiar nombre de llamada.
	    }
 
}
