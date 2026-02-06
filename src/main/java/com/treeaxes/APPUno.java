package com.treeaxes;

import com.treeaxes.CLI.LoginMenu;
import com.treeaxes.CLI.MainMenu;
import com.treeaxes.CLI.RegisterMenu;
import com.treeaxes.Config.AppConfig;
import com.treeaxes.Config.ConfigLoader;
import com.treeaxes.Controller.UserController;
import com.treeaxes.Debug.LogWriter;

import java.util.Scanner;

public class APPUno {

    /*
    * Cargador de configuración
    * Nota: No agregar esta misma linea en otros archivos,
    * las agregarlo mas veces re-carga la configuracion y puede llegar a dar problemas.
    * Es mejor importarlo.
    * */
    public static final ConfigLoader cfg = new ConfigLoader();

    public static void main(String[] args) {
        /*
        * Iniciar Configuración
        * */
        AppConfig.initEnv();

        UserController userController = new UserController();
        Scanner sc = new Scanner(System.in);

        // ========== Main Execution ==========
        boolean loop = true;
        while(loop) {

            // Menu Principal
            System.out.println("\n--- Bienvenido a " + Brand.NOM_APP + " ---\n" +
                    "1. Iniciar Sesión\n" +
                    "2. Registrarse\n" +
                    "3. Salir");

            System.out.print("\nIngresa una opción: ");

            if (sc.hasNextInt()){
                int opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {
                    case 1: // Iniciar Sesion
                        LoginMenu loginMenu = new LoginMenu();

                        try {
                            String user = loginMenu.inicioSesion();
                            LogWriter.create(user);
                            if (user != null) {
                                MainMenu mainMenu = new MainMenu(user);
                                mainMenu.feed();
                                loop = false;
                            }

                        } catch (Exception e) {
                            System.out.println("[!] Error al iniciar Sesion");
                        }

                        break;
                    case 2: // Registrar
                        RegisterMenu registerMenu = new RegisterMenu();

                        try {
                            if (registerMenu.registroMenu()) {
                                System.out.println("[+] Usuario Registrado con exito.\n");
                                break;
                            }
                        } catch (Exception e) {
                            System.out.println("[!] Error al registrar Usuario");
                        }
                        break;

                    case 3: // Exit
                        System.out.println("[+] Saliendo...");
                        loop = false;
                        break;

                    default: // Error
                        System.out.println("[!] Opcion ingresada no valida.\n");
                        break;
                }
            } else {
                System.out.println("[!] Error: Valor ingresado no numerico.");
                sc.nextLine();
            }

        }

    }


}