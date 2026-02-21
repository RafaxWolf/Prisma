package com.treeaxes.Config;

import com.treeaxes.Brand;
import com.treeaxes.Debug.LogWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AppConfig {

    public static final String OS = System.getProperty("os.name").toLowerCase();
    public static final String RUTA_BASE = determinarRutaBaseOS();
    public static final String RUTA_LOGS = RUTA_BASE + File.separator + "logs";
    public static final String RUTA_PROPERTIES = RUTA_BASE + File.separator + "config.properties";
    public static final String RUTA_WALLET = RUTA_BASE + File.separator + "Wallet";


    /// Contenido de "config.properties" que el programa crea al iniciarse por primera vez.
    public static final String CONFIG_CONTENT =
            "# Configuración de " + Brand.NOM_APP + " - " + Brand.NOM_EMPRESA +"\n" +
                    "app.debug=false\n" +
                    "db.url=\"\"\n"+
                    "db.user=\"\"\n" +
                    "db.pass=\"\"\n";


    /// Devuelve la ruta base del sistema operativo que se esta usando
    public static String determinarRutaBaseOS(){
        String userHome = System.getProperty("user.home");
        String developers = Brand.NOM_EMPRESA;
        String appName = Brand.NOM_APP;

        /*
        * Si el sistema operativo es Windows la ruta sera:
        * C:/Users/<user>/AppData/Local/...
        * */
        if (OS.contains("win")) {
            return userHome + File.separator + "AppData"
                    + File.separator + "Local"
                    + File.separator + developers
                    + File.separator + appName;


        /*
        * Si el sistema operativo es MacOS la ruta sera:
        * /Users/<user>/Library/Application Support/...
        * */
        } else if (OS.contains("mac")) {
            return userHome + File.separator + "Library"
                    + File.separator + "Application Support"
                    + File.separator + appName;


        /*
        * Si el sistema operativo es Linux u otro la ruta sera:
        * /home/<user>/.<developers>/<appName>
        * */
        } else {
            return userHome + File.separator + "." +
                    developers + File.separator + appName;
        }
    }


    /// Inicializa el entorno de trabajo creando las carpetas y archivos necesarios
    public static void initEnv(){

        System.out.println("[/] Verificando entorno de trabajo en: " + RUTA_BASE);
        //LogWriter.create("[*] Verificando entorno de trabajo en: " + RUTA_BASE);

        //Crear las carpetas necesarias
        makeDirectory(RUTA_BASE); //Crea la carpeta base
        makeDirectory(RUTA_WALLET); //Crea la carpeta del wallet
        makeDirectory(RUTA_LOGS); //Crea la carpeta de logs

        crearArchivoConfig(RUTA_BASE); //Crea el archivo config.properties
    }


    /// Crea el archivo "config.properties" en la ruta especificada
    /// @param ruta_base Ruta donde crear el archivo.
    private static void crearArchivoConfig(String ruta_base){
        File file = new File(ruta_base,"config.properties");

        if (!file.exists()) {

            try (FileWriter fw = new FileWriter(file)) {
                fw.write(CONFIG_CONTENT);
                System.out.println("[+] Archivo de Configuracion creado.");
                System.out.println("[*] Por favor ingrese sus datos de configuracion aqui: " + RUTA_PROPERTIES);
                //System.exit(0);
            } catch (IOException e){
                System.out.println("[!] Error al escribir config.properties \n" + e.getMessage());
                System.exit(1);
            }

        }

    }


    /// Crea un directorio en la ruta que se le diga. Si ya existe ues entonces no crea nada.
    /// @param ruta Ruta de la carpeta a crear.
    private static void makeDirectory(String ruta){
        File directorio = new File(ruta);

        if (!directorio.exists()) {

            if(directorio.mkdirs()) {
                System.out.println("[+] Directorio creado " + ruta);

            } else {
                System.out.println("[!] Error al crear el directorio " + ruta);
                System.exit(1);
            }
        } else {
            System.out.println("[+] Directorio encontrado: " + ruta);
            //LogWriter.create("[*] Directorio encontrado: " + ruta);
        }
    }


}
