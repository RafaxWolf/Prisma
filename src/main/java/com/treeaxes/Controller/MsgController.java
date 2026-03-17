package com.treeaxes.Controller;

import com.treeaxes.DB.ConnDB;
import com.treeaxes.Debug.LogWriter;
import com.treeaxes.Model.MsgUnit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MsgController {

    private ConnDB conexion;

    public MsgController() {
        conexion = new ConnDB();
    }

    public static boolean mandarMensaje(int user_sender, int user_receiver, String mensaje) {
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

    public static List<MsgUnit> recuperarChat(int user_id_x,int user_id_y){

        ArrayList<MsgUnit> msg_list = new ArrayList<>();

        String sql = "SELECT U_SENDER.username AS EMISOR, M.content_msg AS MENSAJE, TO_CHAR(M.fecha_mensaje, 'DD/MM/YYYY HH24:MI:SS') AS FECHA FROM mensaje M JOIN USERS U_SENDER ON M.id_user_sender = U_SENDER.id_user\n" +
                "WHERE (M.id_user_sender = ? AND M.id_user_receiver = ?) OR (M.id_user_sender = ? AND M.id_user_receiver = ?) ORDER BY M.fecha_mensaje ASC";
                //                         1                          2                         3                          4
                try(Connection conn = ConnDB.getConnection();
                    PreparedStatement ps = conn.prepareStatement(sql)){

                    ps.setInt(1, user_id_x);
                    ps.setInt(2, user_id_y);
                    ps.setInt(3, user_id_y);
                    ps.setInt(4, user_id_x);

                    try (ResultSet rs = ps.executeQuery()){


                        while (rs.next()){

                            String emisorMensaje =  rs.getString("EMISOR");
                            String fechaMensaje =  rs.getString("FECHA");
                            String MensajeContent = rs.getString("MENSAJE");

                            msg_list.add(new MsgUnit(emisorMensaje,MensajeContent,fechaMensaje));

                        }

                    }


                } catch (Exception e) {
                    LogWriter.create("problemas con la linea");
                }


        return msg_list;
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
