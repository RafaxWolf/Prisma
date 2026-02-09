package com.treeaxes.CLI;

import com.treeaxes.Controller.MsgController;

public class Test {

    public static void main(String[] args) {
        MsgController msgController = new MsgController();

        for (int i = 1; i <= 10; i++){
            String msg_send = String.valueOf(Math.floor(Math.random()*80000) + 1);
            System.out.println(msgController.mandarMensaje(2,1,msg_send));
        }


    }
}
