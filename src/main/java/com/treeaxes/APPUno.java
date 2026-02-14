package com.treeaxes;

import com.treeaxes.CLI.LoginMenu;
import com.treeaxes.CLI.MainMenu;
import com.treeaxes.CLI.RegisterMenu;
import com.treeaxes.Config.AppConfig;
import com.treeaxes.Config.ConfigLoader;
import com.treeaxes.Debug.LogWriter;
import com.treeaxes.Model.UserData;

import java.util.Scanner;

public class APPUno {

    /*
     * Cargador de configuración
     * Nota: No agregar esta misma linea en otros archivos,
     * las agregarlo mas veces re-carga la configuracion y puede llegar a dar problemas.
     * Es mejor importarlo.
    */
    public static final ConfigLoader cfg = new ConfigLoader();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        AppConfig.initEnv();

        boolean loop = true;
        while(loop) {
            // Menu
            System.out.println("\n----- Bienvenido a " + Brand.NOM_APP + " -----\n" +
                    "1. Iniciar Sesión\n" +
                    "2. Registrarse\n" +
                    "3. Salir");

            System.out.print("Ingresa una opción: ");
            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion){
                case 1: // Iniciar Sesion
                    LoginMenu loginMenu = new LoginMenu();
                    try{
                        String user = loginMenu.inicioSesion();
                        LogWriter.create("[*] Logged User: " + user);

                        if (user != null){
                            MainMenu mainMenu = new MainMenu(user);
                            mainMenu.MainPage();
                            loop = false;
                        }

                    } catch (Exception e) {
                        System.out.println("[+] Error al iniciar Sesion: " + e.getMessage());
                        LogWriter.create("[+] Error al iniciar Sesion: " + e.getMessage());
                    }

                    break;

                case 2: // Registrar
                    RegisterMenu  registerMenu = new RegisterMenu();
                    try{
                        if (registerMenu.registroMenu()) {
                            System.out.println("\n[+] Usuario Registrado con exito.\n");
                            break;
                        }
                    } catch (Exception e) {
                        System.out.println("\n[!] Error al registrar el Usuario\n");
                    }
                    break;

                case 3: // Exit
                    System.out.println("\n[+] Saliendo...");
                    loop = false;
                    break;

                default: // Error
                    System.out.println("[!] Opcion ingresada no valida.\n");
                    break;
            }


        }


    }

    /// Pagina de WIP (Work In Progress)
    /// @param session Sesion del Usuario.
    public static void WIP_page(UserData session){
        System.out.println("\n[+] Hello " + session.getUsername());
        System.out.println("[-] This page is in Working Progress...");
        System.exit(0);
    }


}