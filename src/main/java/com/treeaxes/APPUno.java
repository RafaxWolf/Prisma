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

    public static void main(String[] args) {
        UserController userController = new UserController();
        Scanner sc = new Scanner(System.in);

        // Cargar la Configuracion
        AppConfig.initEnv();

        boolean loop = true;
        while(loop) {
            // Menu
            System.out.println("\n--- Bienvenido a "+Brand.NOM_APP+" ---\n" +
                    "1. Iniciar Sesión\n" +
                    "2. Registrarse\n" +
                    "3. Salir");

            System.out.print("\nIngresa una opción: ");
            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion){
                case 1: // Iniciar Sesion
                    LoginMenu loginMenu = new LoginMenu();

                    try{
                        String user = loginMenu.inicioSesion();
                        LogWriter.create(user);
                        if (user != null){
                            MainMenu mainMenu = new MainMenu(user);
                            mainMenu.feed();
                            loop = false;
                        }

                    } catch (Exception e) {
                        System.out.println("[!] Error al iniciar Sesion");
                    }

                    break;
                case 2: // Registrar
                    RegisterMenu  registerMenu = new RegisterMenu();

                    try{
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


        }


    }


}