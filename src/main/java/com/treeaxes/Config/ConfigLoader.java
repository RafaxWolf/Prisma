package com.treeaxes.Config;

import com.treeaxes.Debug.LogWriter;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {
    private Properties prop = new Properties();

    public ConfigLoader() {
        cargarConfiguracion(AppConfig.RUTA_PROPERTIES);
    }

    public void cargarConfiguracion(String rutaArchivo){

        // Cargar archivo config.properties
        try (InputStream input = new FileInputStream(rutaArchivo)){
            prop.load(input);
            System.out.println("[*] Configuracion cargada desde "+ rutaArchivo);

        } catch (IOException e){
            System.out.println("[!] Error al intentar cargar: " + rutaArchivo);
        }

    }

    // Obtener valor de una propiedad
    public String getProperty(String key) {
        return prop.getProperty(key);
    }

    // Obtener valor booleano de una propiedad
    public boolean getBooleanProperty(String key) {
        String valor = prop.getProperty(key);
        return valor != null && Boolean.parseBoolean(valor);
    }



}
