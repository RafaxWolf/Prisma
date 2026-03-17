package com.treeaxes.CLI;

import com.treeaxes.Controller.UserController;
import com.treeaxes.Debug.LogWriter;

import java.util.Scanner;

public class LoginMenu {

    UserController userController = new UserController();
    Scanner sc = new Scanner(System.in);

    private String user, pwd;

    /// Constructor del Inicio de Sesion
    public LoginMenu() {}

    public String inicioSesion() {

        while (true) {

            System.out.println("\n(Powered by LoginMaster Technology)");
            System.out.println("\n---Inicio de Sesion---");

            System.out.print("Ingresa Usuario (escribe salir para volver al menú principal): ");
            user = sc.nextLine();

            // Debug: Muestra el usuario
            LogWriter.create("[*] Username: " + user);

            if (user.equalsIgnoreCase("salir")) {
                break;
            }

            System.out.print("Ingresa Contraseña: ");
            pwd = sc.nextLine();

            // Debug: Muestra la Contraseña
            LogWriter.create("[*] Password: " + pwd);

            if (userController.iniciarSesion(user, pwd)) {
                System.out.println("Has iniciado sesion con éxito.\n");
                return user;
            } else {
                System.out.println("[!] Usuario o Contraseña incorrectos.");
                System.out.println("[!] Presiona enter para continuar...");
                sc.nextLine();
            }

        }

        return null;
    }


}
