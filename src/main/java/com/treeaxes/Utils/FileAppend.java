package com.treeaxes.Utils;

import com.treeaxes.Debug.DMsg;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileAppend {

    public FileAppend() {
    }

    public static void guardarRegistro(String ruta,String msg) {

        try (FileWriter fw = new FileWriter(ruta,true);
             PrintWriter pw = new PrintWriter(fw)){
            pw.println(msg);
        } catch (IOException e) {
            DMsg.msg("Error al guardar el registro: " + e.getMessage());
        }

    }


}
