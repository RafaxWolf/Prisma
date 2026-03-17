package com.treeaxes.Debug;

import com.treeaxes.Config.AppConfig;
import com.treeaxes.Utils.FileAppend;
import com.treeaxes.Utils.GetTimeNow;

public class LogWriter {

    public LogWriter() {}

    /// LogWriter - Método create
    ///
    /// Crea un nuevo registro en el archivo de log con el mensaje proporcionado.
    /// @param msg El mensaje que se desea registrar en el archivo de log.
    public static void create(String msg){
        DMsg.msg(msg);
        FileAppend.guardarRegistro(AppConfig.RUTA_LOGS+"/"+GetTimeNow.getDate()+".log","["+GetTimeNow.getFormattedTime()+"] " + msg);
    }






}
