package com.treeaxes.CLI;

import com.treeaxes.Controller.UserController;
import com.treeaxes.Model.UserData;

import java.util.Scanner;

public class MainMenu {

    UserController userController = new UserController();
    Scanner sc = new Scanner(System.in);
    private String user;

    public MainMenu(String user) {
        this.user = user;
    }

    public void feed(){

        while(true){
            System.out.println("Bienvenido " + user);
            System.out.println("feed de " + user);
            UserData userData = userController.getUserInfo(user);
            System.out.println(userData);
            sc.nextLine();
        }
    }
}
