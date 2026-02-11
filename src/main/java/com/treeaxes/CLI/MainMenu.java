package com.treeaxes.CLI;

import com.treeaxes.Controller.UserController;
import com.treeaxes.Model.UserData;

import java.util.Scanner;

public class MainMenu {

    UserController userController = new UserController();
    Scanner sc = new Scanner(System.in);

    private UserData userData;
    private String user;

    boolean loop = true;

    public MainMenu(String user) {
        this.user = user;
        this.userData = userController.getUserInfo(user);
    }

    public void MainPage(){
        System.out.println("====== Bienvenido " + user + " ======");

        while(loop){

            System.out.println("\n----- Home -----\n" +
                            "1. Nuevo Chat\n" +
                            "2. Mis Chats\n" +
                            "3. Salir\n");

            System.out.print("[+] Ingresa opción: ");
            int choice = sc.nextInt();

            switch(choice){

                case 1: // Iniciar un nuevo Chat
                    ChatsMenu.NewChat(userController.getUserInfo(user));
                    break;

                case 2: // Ver Chats activos
                    ChatsMenu.MyChats(userController.getUserInfo(user));
                    break;

                case 3: // Salir
                    loop = false;
                    break;
            }

        }

    }
}
