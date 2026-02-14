package com.treeaxes.CLI;

import com.treeaxes.Controller.UserController;
import com.treeaxes.Model.User;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Objects;
import java.util.Scanner;

public class RegisterMenu {

    Scanner sc = new Scanner(System.in);
    UserController userController = new UserController();

    /// Constructor del Registro de Usuario
    public RegisterMenu() {
    }

    /// Menu de Registro
    public boolean registroMenu(){

        while(true) {
            System.out.println("\n(Powered by LoginMaster Technology)");
            System.out.println("\n---Registro---");
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
                return true;
            }

            System.out.print("Ingrese una Contraseña: ");
            String pwd = sc.nextLine();

            System.out.print("Ingrese de nuevo la Contraseña: ");
            String verifypwd = sc.nextLine();

            if(!verifypwd.equals(pwd)){
                System.out.println("[!] Las contraseñas no conciden!");
                System.out.println("[!] Vuelva a intentarlo:");
            }

            // Registra el usuario en la base de datos
            User user = new User(username, correo, verifypwd, 4);

            if (userController.registrarUser(user)) {
                System.out.println("[+] Usuario registrado correctamente.\n");
                break;
            }

        }

        return false;
    }


}
