package com.treeaxes.Debug;

import com.treeaxes.Config.ConfigLoader;

public class DMsg {

    private static final ConfigLoader cfg =  new ConfigLoader();

    public DMsg() {
    }

    public static void msg(String msg) {
        if (cfg.getBooleanProperty("app.debug")) {
            System.out.println(msg);
        }
    }

}
