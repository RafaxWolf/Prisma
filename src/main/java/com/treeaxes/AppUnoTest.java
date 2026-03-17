package com.treeaxes;

import com.treeaxes.CLI.MainMenu;
import com.treeaxes.Config.ConfigLoader;
import com.treeaxes.Controller.UserController;

import java.util.Scanner;

public class AppUnoTest {

    /*
     * Cargador de configuración
     * Nota: No agregar esta misma linea en otros archivos,
     * agregarlo mas veces recarga la configuracion y puede llegar a dar problemas.
     * */
    public static final ConfigLoader cfg = new ConfigLoader();


    public static void main(String[] args) {

        UserController userController = new UserController();
        Scanner sc = new Scanner(System.in);

        String user = "panxitovilla";

        MainMenu mainMenu = new MainMenu(user);
        mainMenu.MainPage();

    }
}
