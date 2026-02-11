package com.treeaxes.CLI;

import com.treeaxes.Controller.MsgController;
import com.treeaxes.Controller.UserController;
import com.treeaxes.Model.UserConversations;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {

        List<UserConversations> list = UserController.getChats(2);

        for (UserConversations userConversations : list) {
            System.out.println(userConversations.getUsername());
            System.out.println(userConversations.getId_user());
            System.out.println("-----");
        }

    }
}
