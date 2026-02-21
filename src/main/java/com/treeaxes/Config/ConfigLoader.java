package com.treeaxes.Config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {
    private final Properties prop = new Properties();
    private final static String[] REQUIRED_PROP = {
            "db.url",
            "db.user",
            "db.pass"
    };

    public ConfigLoader() {
        cargarConfiguracion(AppConfig.RUTA_PROPERTIES);
    }

    /// Cargador y validador de Configuracion
    ///
    /// Carga y valida la configuracion del archivo "config.properties"
    /// @param rutaArchivo Ruta del archivo "config.properties"
    public void cargarConfiguracion(String rutaArchivo){

        try (InputStream input = new FileInputStream(rutaArchivo)){

            // Cargar las propiedades del archivo
            prop.load(input);
            System.out.println("[*] Configuración cargada desde "+ rutaArchivo);

        } catch (IOException e){
            System.out.println("[!] Error al intentar cargar: " + rutaArchivo);
            System.out.println("[!] Creando archivo de configuración desde cero...");
            AppConfig.initEnv();
        }

        // ====== Validadores ======
        // Verificador de estructura del archivo config.properties
        System.out.println("[/] Validando Configuración...");
        for (String key : REQUIRED_PROP) {
            if(prop.isEmpty()) {
                System.out.println("[!] El Archivo de configuración no existe.");
                System.out.println("[!] Creando el archivo de configuración desde cero...");
                AppConfig.initEnv();
            }

            if(!prop.containsKey(key)) { // Si alguna de las configuraciones no se encuentra
                System.out.println("[!] Error: La Estructura del archivo es incorrecta.");
                System.out.println("[!] La propiedad esencial '" + key + "' no se encuentra en: " + rutaArchivo);
                System.out.println("[!] Por favor, revise el archivo de configuración.");
                System.exit(1);
            }
        }

        // Verificar que las propiedades esenciales no esten vacias
        for (String key : REQUIRED_PROP) {
            String value = prop.getProperty(key);
            if (emptyConfig(value)) { // Si alguna de las configuraciones esta vacia devuelve un error.
                System.out.println("[!] Error: La propiedad esencial '" + key + "' está vacía en: " + rutaArchivo);
                System.out.println("[!] Por favor, complete el archivo de configuración.");
                System.exit(1);
            }
        }

        // Validar app.debug sea booleano
        String debugValue = prop.getProperty("app.debug");
        if(!debugValue.equalsIgnoreCase("true") && !debugValue.equalsIgnoreCase("false")) { // Si "app.debug" no es "true" o "false" devuelve un error.

            System.out.println("[!] Error: La propiedad 'app.debug' debe ser 'true' o 'false' en: " + rutaArchivo);
            System.out.println("[!] Por favor, corrija el archivo de configuración.");
            System.exit(1);
        }

        System.out.println("[+] La Configuración es valida.");
    }


    /// Obtener valor de una propiedad.
    ///
    /// Obtiene el valor de una propiedad
    /// @param key Propiedad de donde obtener el valor
    public String getProperty(String key) {
        return prop.getProperty(key);
    }

    /// Obtener valor booleano de una propiedad
    public boolean getBooleanProperty(String key) {
        String valor = prop.getProperty(key);
        return valor != null && Boolean.parseBoolean(valor);
    }

    /// Validador de Configuracion.
    ///
    /// Verifica que los apartados requeridos de la configuracion no esten vacios.
    private static boolean emptyConfig(String value){
        if(value == null) return true;
        value = value.trim();

        return value.isEmpty() || value.equals("\"\"");
    }


}
