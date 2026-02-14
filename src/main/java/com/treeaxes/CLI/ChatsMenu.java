package com.treeaxes.CLI;

import com.treeaxes.APPUno;
import com.treeaxes.Controller.UserController;
import com.treeaxes.Debug.LogWriter;
import com.treeaxes.Model.IndexChat;
import com.treeaxes.Model.UserConversations;
import com.treeaxes.Model.UserData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChatsMenu {

    public static void NewChat(UserData session) {
        APPUno.WIP_page(session);
    }

    public static void MyChats(UserData session) {
        // Listas
        List<UserConversations> userList = UserController.getChats(session.getId_user());
        List<IndexChat> indexList = new ArrayList<IndexChat>();

        // Escaner y Loop
        Scanner sc = new Scanner(System.in);
        boolean loop = true;

        while (loop) {
            System.out.println("\n----- Chats Menu -----");
            if (!userList.isEmpty()) {
                for (UserConversations userConversations : userList) {
                    System.out.println();
                    System.out.println(userList.indexOf(userConversations) + 1 + ") " + userConversations.getUsername());
                    indexList.add(new IndexChat(userConversations.getId_user(), userList.indexOf(userConversations) + 1));
                }

                // Creador de Cancelar
                UserConversations salirOpcion = new UserConversations(9999, "Cancelar");
                indexList.add(new IndexChat(salirOpcion.getId_user(), userList.size() + 1));
                System.out.println();
                System.out.println(indexList.getLast().getIndice() + ") " + salirOpcion.getUsername());
                LogWriter.create(indexList.toString());


                System.out.print("Ingresa una opción: ");
                if(!sc.hasNextInt()){
                    System.out.println("[!] Debes ingresar un numero.");
                    sc.nextLine();
                    continue;
                }

                int choice = sc.nextInt();
                sc.nextLine();

                boolean selectFound = false;

                for (IndexChat indexChat : indexList) {
                    if (choice == indexChat.getIndice()) {
                        selectFound = true;

                        if (indexChat.getId_user() == 9999) {
                            System.out.println("Cancelando...");
                            loop = false;
                        } else {
                            System.out.println("Mostrando chat con " + UserController.getUsername(indexChat.getId_user()));
                            sc.nextLine();
                        }
                        break;
                    }
                }

                if (!selectFound){
                    System.out.println("Opción no válida.");
                }

                // Limpia la lista para que no haya un Overflow de datos.
                indexList.clear();

            } else {
                System.out.println("----- No chats -----\n");
                loop = false;
                sc.nextLine();
            }

        }
    }





}
