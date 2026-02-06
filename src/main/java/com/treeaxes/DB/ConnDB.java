package com.treeaxes.DB;

import com.treeaxes.Config.AppConfig;
import com.treeaxes.Debug.LogWriter;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static com.treeaxes.APPUno.cfg;


public class ConnDB {

    // CREDENTIALS
    private final static String TNS_ADMIN_PATH = AppConfig.RUTA_WALLET;
    private final static String DBURL = cfg.getProperty("db.url");
    private final static String USER = cfg.getProperty("db.user");
    private final static String PASS = cfg.getProperty("db.pass");


    //CONSTRUCTOR
    public ConnDB() {}

    private static final File wallet_folder = new File(TNS_ADMIN_PATH);

    /// Validador de Wallet
    ///
    /// Valida si la carpeta 'Wallet' se encuentra vacia.
    /// @param folder Carpeta donde se encuentra la 'Wallet'
    private static boolean emptyWallet(File folder){
        if(!folder.exists()){
            return false;
        }

        String[] content = folder.list();
        return content != null && content.length == 0;
    }

    static {
        // Validador de wallet
        if(emptyWallet(wallet_folder)){
            System.out.println("[!] Error: La Carpeta 'Wallet' se encuentra Vacia!");
            LogWriter.create("[!] Error: La Carpeta 'Wallet' se encuentra Vacia!");
            System.out.println("[!] Porfavor ingrese los archivos de su 'Oracle Autonomous Database Wallet' en esta carpeta.");
            LogWriter.create("[!] Porfavor ingrese los archivos de su 'Oracle Autonomous Database Wallet' en esta carpeta.");
            System.exit(1);
        }

        // Configurar la variable de entorno TNS_ADMIN para Oracle Wallet
        System.setProperty("oracle.net.tns_admin", TNS_ADMIN_PATH);
        LogWriter.create("[*] TNS_ADMIN configurado en: " + TNS_ADMIN_PATH);

        try {
            // Verifica el driver JDBC de Oracle
            Class.forName("oracle.jdbc.driver.OracleDriver");
            LogWriter.create("[*] Driver JDBC de Oracle cargado correctamente.");

        } catch (ClassNotFoundException e) { // Error si no encuentra el driver
            System.out.println("[!] Error al cargar el driver JDBC de Oracle: " + e.getMessage());
            LogWriter.create("[!] Error al cargar el driver JDBC de Oracle: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        try {
            LogWriter.create("[/] Debug: Intentando conectar a: " + DBURL);
            return DriverManager.getConnection(DBURL, USER, PASS);
        } catch (SQLException e) {
            System.out.println("[!] Error de conexión: " + e.getMessage());
            LogWriter.create("[!] Error de conexión: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }


}