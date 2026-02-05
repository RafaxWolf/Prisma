package com.treeaxes.DB;

import com.treeaxes.Config.AppConfig;
import com.treeaxes.Config.ConfigLoader;
import com.treeaxes.Debug.DMsg;
import com.treeaxes.Debug.LogWriter;

import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnDB {


    static ConfigLoader cfg = new ConfigLoader();

    // CREDENTIALS
    final static String TNS_ADMIN_PATH = AppConfig.RUTA_WALLET;
    final static String DBURL = cfg.getProperty("db.url");
    final static String USER = cfg.getProperty("db.user");
    final static String PASS = cfg.getProperty("db.pass");


    //CONSTRUCTOR
    public ConnDB() {}


    static {
        System.setProperty("oracle.net.tns_admin", TNS_ADMIN_PATH);
        LogWriter.create("[*] TNS_ADMIN configurado en: " + TNS_ADMIN_PATH);

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            LogWriter.create("[*] Driver JDBC de Oracle cargado correctamente.");

        } catch (ClassNotFoundException e) {
            //System.out.println("[!] Error al cargar el driver JDBC de Oracle: " + e.getMessage());
            LogWriter.create("[!] Error al cargar el driver JDBC de Oracle: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        try {
            LogWriter.create("[/] Debug: Intentando conectar a: " + DBURL);

            return DriverManager.getConnection(DBURL, USER, PASS);
        } catch (SQLException e) {
            //System.out.println("[!] Error de conexión: " + e.getMessage());
            LogWriter.create("[!] Error de conexión: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }


}