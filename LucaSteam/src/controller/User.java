package controller;

import gui.Menu;
import services.ISuperServices;
import services.SuperServices;


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
            switch (Datos.ScanInt()) {//Lee un dato de tipo Int
                case 1:
                    //Cargar archivo en el programa y generar List (collection)
                    services.ChargeList();
                    break;

                case 2:
                    //Añadir un juego a la List
                    services.AddGame();
                    break;

                case 3:
                    //Mostrar la Lista de Juegos completa.
                    services.PrintGames();
                    break;

                case 4:
                    //Mostrar la Lista de Juegos filtrados por Nombre
                    services.ShowGameFilterName();
                    break;

                case 5:
                	//Mostrar la Lista de Juegos filtrados por Plataforma
                    services.ShowGameFilterPlatform();
                    break;

                case 6:
                	//Mostrar la Lista de Juegos filtrados por Año
                    services.ShowGameFilterYear();
                    break;

                case 7:
                	//Mostrar la Lista de Juegos filtrados por Genero
                    services.ShowGameFilterGenre();
                    break;

                case 8:
                	//Mostrar la Lista de Juegos filtrados por Editor
                    services.ShowGameFilterPublisher();
                    break;
                    
                case 9:
                	//Actualizar una categoria de un juego
                    services.UpdateGame();
                    break;
                   
                case 10:
                    //Borrar un Juego
                    services.DeleteGame();
                    break;
                    
                  //Guardar y salir
                case 0:
                	services.SaveList();
                    continuar = exit();
                    break;
            }
        } catch (Exception e) {
            System.out.println("error: " + e.toString());
        }
        return continuar;
    }

    private boolean exit() throws Exception {//ScanString lee un dato por Scanner tipo String
        String sino = Datos.ScanString("   Estas seguro de que desea guardar y salir? (S/N)");
        return (sino.toUpperCase().charAt(0) != 'S'); //La cambia a mayuscula
    }


}