package com.treeaxes.CLI;

import com.treeaxes.Controller.UserController;
import com.treeaxes.Debug.DMsg;

import java.util.Scanner;

public class LoginMenu {

    UserController userController = new UserController();
    Scanner sc = new Scanner(System.in);
    private String user,pwd;

    public LoginMenu() {}

    public String inicioSesion() {

        ClearTerminal cl = new ClearTerminal();
        while (true) {

            System.out.println("\n---Inicio de Sesion---");
            System.out.println("(Powered by LoginMaster Technology)");

            System.out.print("Ingresa Usuario (escribe salir para volver al menú principal): ");
            user = sc.nextLine();

            DMsg.msg("[*] Username: " + user);

            if (user.equalsIgnoreCase("salir")) {
                break;
            }

            System.out.print("Ingresa Contraseña: ");
            pwd = sc.nextLine();

            DMsg.msg("[*] Password: " + pwd);

            if (userController.iniciarSesion(user, pwd)) {
                System.out.println("Has iniciado sesion con éxito.\n");
                return user;
            } else {
                System.out.println("No iniciaste...");
                sc.nextLine();
                cl.clear();
            }

        }

        return null;
    }


}
