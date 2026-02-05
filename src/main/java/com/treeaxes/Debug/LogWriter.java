package com.treeaxes.Debug;

import com.treeaxes.Config.AppConfig;
import com.treeaxes.Utils.FileAppend;
import com.treeaxes.Utils.GetTimeNow;

public class LogWriter {

    public LogWriter() {}

    // Crear un registro en el archivo log
    public static void create(String msg){
        DMsg.msg(msg);
        FileAppend.guardarRegistro(AppConfig.RUTA_LOGS+"/"+GetTimeNow.getDate()+".log","["+GetTimeNow.getFormattedTime()+"] " + msg);
    }






}
