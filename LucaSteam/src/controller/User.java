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
                    //Cargar archivo en el programa y generar List (collection)
                    services.loadList();
                    break;

                case 2:
                    //Añadir un juego a la List
                	// pasar por parametro un juego para añadir
                    services.addGame();
                    break;

                case 3:
                    //Mostrar la Lista de Juegos completa.
                    services.printGames();
                    break;

                case 4:
                    //Mostrar la Lista de Juegos filtrados por Nombre
                 //   services.ShowGameFilterName();
                    break;

                case 5:
                	//Mostrar la Lista de Juegos filtrados por Plataforma
                  //  services.ShowGameFilterPlatform();
                    break;

                case 6:
                	//Mostrar la Lista de Juegos filtrados por Año
                  //  services.ShowGameFilterYear();
                    break;

                case 7:
                	//Mostrar la Lista de Juegos filtrados por Genero
                  //  services.ShowGameFilterGenre();
                    break;

                case 8:
                	//Mostrar la Lista de Juegos filtrados por Editor
               //     services.ShowGameFilterPublisher();
                    break;
                    
                case 9:
                	//Actualizar una categoria de un juego
                  //  services.UpdateGame();
                    break;
                   
                case 10:
                    //Borrar un Juego
                  //  services.DeleteGame();
                    break;
                    
                  //Guardar y salir
                case 0:
                //	services.SaveList();
                    continuar = exit();
                    break;
            }
        } catch (Exception e) {
            System.out.println("error: " + e.toString());
        }
        return continuar;
    }

    private boolean exit() throws Exception {//ScanString lee un dato por Scanner tipo String
        System.out.println("Estas seguro de que desea guardar y salir? (S/N)");
    	String sino = DataInput.writeLine();
        return (sino.toUpperCase().charAt(0) != 'S'); //La cambia a mayuscula
    }


}