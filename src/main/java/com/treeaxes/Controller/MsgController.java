package com.treeaxes.Controller;

import com.treeaxes.DB.ConnDB;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class MsgController {

    private ConnDB conexion;

    public MsgController() {
        conexion = new ConnDB();
    }

    public boolean mandarMensaje(int user_sender, int user_receiver, String mensaje) {
        try {
            // Consulta SQL
            String sql = "INSERT INTO MENSAJE(id_user_sender,id_user_receiver,content_msg) VALUES (?,?,?)";

            try(Connection conn = ConnDB.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setInt(1, user_sender);
                ps.setInt(2, user_receiver);
                ps.setString(3, mensaje);

                return ps.executeUpdate() > 0;

            }

        } catch (Exception e) {
            System.out.println("[!] Error: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }


    /* DEPRECATED
    public boolean mandarMensaje(String username_receiver,int id_user_sender,String message) {


        try {
            int user_receiver = UserController.getIdUser(username_receiver);
            int user_sender = id_user_sender;
            String mensaje = message;

            // Consulta SQL
            String sql = "INSERT INTO MENSAJE(id_user_sender,id_user_receiver,content_msg) VALUES (?,?,?)";

            try(Connection conn = ConnDB.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setInt(1, user_sender);
                ps.setString(2, username_receiver);
                ps.setString(3, message);

                return ps.executeUpdate() > 0;

            } catch (SQLException ex) {
                System.out.println("[!] Error: " + ex.getMessage());
                ex.printStackTrace();
            }


        } catch (Exception e) {
            System.out.println("Error al obtener el usuario " + username_receiver);
        }

        return false;
    }

    public List<MensajeDownload> listarMensajes(int id_user_download) {
        ArrayList mensajes = new ArrayList();

        // Consulta SQL
        String sql = "SELECT * FROM MENSAJE WHERE id_user_receiver = ?";


        try(Connection conn = ConnDB.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1,id_user_download);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){

                int id_user_sender = rs.getInt("id_user_sender");
                String fecha = rs.getString("fecha_mensaje");
                String mensaje = rs.getString("content_msg");

                mensajes.add(new MensajeDownload(UserController.getUsername(id_user_sender),fecha,mensaje));
            }

            return mensajes;


        } catch (SQLException ex) {
            System.out.println("[!] Error: " + ex.getMessage());
        }


        return mensajes;
    }

    */



}
