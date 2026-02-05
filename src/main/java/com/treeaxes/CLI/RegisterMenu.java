package com.treeaxes.CLI;

import com.treeaxes.Controller.UserController;
import com.treeaxes.Model.User;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Scanner;

public class RegisterMenu {

    Scanner sc = new Scanner(System.in);
    UserController userController = new UserController();

    public RegisterMenu() {
    }

    public boolean registroMenu(){

        while(true) {
            System.out.println("\n---Registro---");
            System.out.println("(Powered by LoginMaster Technology)");
            System.out.print("Ingresa un Username: ");
            String username = sc.nextLine();

            // Validador
            if (username.equalsIgnoreCase("salir")) {
                break;
            }

            System.out.print("Ingresa un Correo: ");
            String correo = sc.nextLine();

            if (!correo.contains("@")) {
                System.out.println("[!] Correo ingresado no valido.");
                break;
            }

            System.out.print("Ingresa una password: ");
            String pwd = sc.nextLine();

            // Constructor
            User user = new User(username, correo, pwd, 4);

            if (userController.registrarUser(user)) {
                System.out.println("Usuario registrado correctamente\n");
            }

        }

        return false;
    }


}
