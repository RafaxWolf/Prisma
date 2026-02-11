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

    public void feed(){
        System.out.println("Bienvenido " + user);

        while(loop){

            System.out.println("\n--- Home ---\n" +
                            "1. Mis Chats\n" +
                            "2. Salir\n");

            System.out.print("Ingresa opción: ");
            int choice = sc.nextInt();

            switch(choice){

                case 1:
                    ChatsMenu.MyChats(userController.getUserInfo(user));
                    break;

                case 2:
                    loop = false;
                    break;
            }



            /*
            System.out.println("Bienvenido " + user);
            System.out.println("feed de " + user);
            UserData userData = userController.getUserInfo(user);
            System.out.println(userData);
            sc.nextLine();*/
        }

    }
}
