package controller;

import gui.Menu;
import services.ISuperServices;
import services.SuperServices;
import utilidades.DataInput;


public class User {

	private ISuperServices services = new SuperServices();
	
	
	
	/**
	*@param:none
	*return: void
	*/
    public void StartListGames() {
        boolean seguir = true;
        start();
        do {
            Menu.showMenu(); //Muestra el menu
            seguir = this.chooseOptions(); //Entra dentro del metodo de abajo. El switch
        } while (seguir);
        System.out.println("   --- Fin del Programa ---");
    }
    
    /**
	*@param:none
	*return: void
	*/
    public boolean chooseOptions() {

        boolean continuar = true;
        
        try {
            switch (DataInput.writeNumber()) {//Lee un dato de tipo Int
                case 1:
                	services.addGame();
                    
                    break;

                case 2:
                	services.printGames();
             
                    break;

                case 3:
                   services.printByGenre();
                    
                    break;

                case 0:
                    continuar = false;
                    
                    break;
            }
        } catch (Exception e) {
            System.out.println("error: " + e.toString());
        }
        return continuar;
    }

   
    
    public void start() {
    	services.loadList();
    }


}