package com.treeaxes.Config;

import com.treeaxes.Brand;
import com.treeaxes.Debug.DMsg;
import com.treeaxes.Debug.LogWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AppConfig {

    public static final String OS = System.getProperty("os.name").toLowerCase();
    public static final String RUTA_BASE = determinarRutaBaseOS();
    public static final String RUTA_LOGS = RUTA_BASE + File.separator + "logs";
    public static final String RUTA_PROPERTIES = RUTA_BASE + File.separator + "config.properties";
    public static final String RUTA_WALLET = RUTA_BASE + File.separator + "Wallet";


    // El config por defecto que genera el programa la primera vez que lo abres.
    public static final String CONFIG_CONTENT =
            "# Configuración de "+ Brand.NOM_APP +"\n" +
                    "app.debug=false\n" +
                    "db.url=\"\"\n"+
                    "db.user=\"\"\n" +
                    "db.pass=\"\"\n";




    // Devuelve la ruta base del sistema operativo que se esta usando
    // en el caso de windows sera /Users/user/
    public static String determinarRutaBaseOS(){
        String userHome = System.getProperty("user.home");
        String appName = Brand.NOM_APP;
        String developers = Brand.NOM_EMPRESA;

        if (OS.contains("win")) {
            return userHome + File.separator + "AppData"
                    + File.separator + "Local"
                    + File.separator + developers
                    + File.separator + appName;

        } else if (OS.contains("mac")) {

            return userHome + File.separator + "Library"
                    + File.separator + "Application Support"
                    + File.separator + appName;
        } else {
            return userHome + File.separator + "." + appName;
        }
    }




    // Lo primero que ejecuta el programa completo al iniciar, y crea los directorios y archivos si es que es la primera vez que se ejecuta
    public static void initEnv(){

        LogWriter.create("[*] Verificando entorno de trabajo en: " + RUTA_BASE);

        makeDirectory(RUTA_BASE);

        makeDirectory(RUTA_WALLET);

        makeDirectory(RUTA_LOGS);

        crearArchivoConfig(RUTA_BASE);

    }



    //Crea el archivo "config.properties" en la ruta /Users/user/AppData/Local/...
    private static void crearArchivoConfig(String ruta_base){
        File file = new File(ruta_base,"config.properties");

        if (!file.exists()) {

            try (FileWriter fw = new FileWriter(file)) {
                fw.write(CONFIG_CONTENT);

            } catch (IOException e){

                LogWriter.create("Error al escribir config.properties \n" + e.getMessage());
            }

        } else {

            LogWriter.create("[*] Archivo properties ya existe!");
        }

    }



    // Crea un directorio en la ruta que se le diga. Si ya existe ues entonces no crea nada.
    private static void makeDirectory(String ruta){
        File directorio = new File(ruta);

        if (!directorio.exists()) {

            if(directorio.mkdirs()) {
                LogWriter.create("[+] Directorio creado " + ruta);
                LogWriter.create("Por favor ingresa tus datos de configuracion aca");
            } else {


                LogWriter.create("[!] Error al crear el directorio " + ruta);

            }

        } else {
            LogWriter.create("Directorio encontrado + ruta");
        }
    }



}
