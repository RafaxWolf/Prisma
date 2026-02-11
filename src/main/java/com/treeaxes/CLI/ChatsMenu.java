package com.treeaxes.CLI;

import com.treeaxes.Controller.UserController;
import com.treeaxes.Debug.LogWriter;
import com.treeaxes.Model.IndexChat;
import com.treeaxes.Model.User;
import com.treeaxes.Model.UserConversations;
import com.treeaxes.Model.UserData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChatsMenu {

    public static void MyChats(UserData session) {
        // Listas
        List<UserConversations> userList = UserController.getChats(session.getId_user());
        List<IndexChat> indexList = new ArrayList<IndexChat>();

        // Escaner y Loop
        Scanner sc = new Scanner(System.in);
        boolean loop = true;

        while (loop) {
            System.out.println("\n--- Chats Menu ---");
            if (!userList.isEmpty()) {
                for (UserConversations userConversations : userList) {
                    System.out.println();
                    System.out.println(userList.indexOf(userConversations) + 1 + ") " + userConversations.getUsername());
                    indexList.add(new IndexChat(userConversations.getId_user(), userList.indexOf(userConversations) + 1));
                }

                UserConversations salirOpcion = new UserConversations(9999, "Salir");
                indexList.add(new IndexChat(salirOpcion.getId_user(), userList.size() + 1));
                System.out.println();
                System.out.println(indexList.getLast().getIndice() + ") " + salirOpcion.getUsername());


                boolean loop2 = true;

                while (loop2) {
                    LogWriter.create(indexList.toString());
                    System.out.print("Ingresa una opción: ");
                    int choice = sc.nextInt();
                    sc.nextLine();

                    for (IndexChat indexChat : indexList) {

                        if (choice == indexList.getLast().getIndice()) {
                            System.out.println("salir");
                            break;
                        }else if (choice == indexChat.getIndice()) {
                            System.out.println("Mostrando chat con "+ UserController.getUsername(indexChat.getId_user()));
                        } else {
                            System.out.println("Opción no válida.");
                            break;
                        }

                    }

                }

            } else {
                System.out.println("--- No chats ---\n");
                loop = false;
                sc.nextLine();
            }

        }
    }





}
