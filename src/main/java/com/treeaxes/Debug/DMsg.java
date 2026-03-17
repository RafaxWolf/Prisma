package com.treeaxes.Debug;


import static com.treeaxes.APPUno.cfg;

public class DMsg {

    public DMsg() {}

    // Mostrar mensaje de depuración si app.debug está habilitado
    public static void msg(String msg) {
        if (cfg.getBooleanProperty("app.debug")) {
            System.out.println(msg);
        }
    }

}
