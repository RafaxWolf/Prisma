package com.treeaxes.Controller;
import com.treeaxes.DB.ConnDB;
import com.treeaxes.Debug.LogWriter;
import com.treeaxes.Model.User;
import com.treeaxes.Model.UserData;

import java.sql.*;

public class UserController {

    private ConnDB conexion; // Conexion a la DataBase

    public UserController() {
        conexion = new ConnDB();
    }

    // Registrar Usuario
    public boolean registrarUser(User user) {

        // Consulta SQL
        String sql = "INSERT INTO USERS(username,email,pwd,id_role) VALUES (?,?,?,?)";

        try(Connection conn = ConnDB.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setString(1, user.getUsername());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPwd());
            ps.setInt(4, user.getRole());

            return ps.executeUpdate() > 0;
        }
        catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("usuario ya esta registrado");
            //LogWriter.create("[*] usuario ya esta registrado");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            //LogWriter.create(ex.getMessage());
        }



        return false;
    }

    // iniciar sesion
    public boolean iniciarSesion(String username, String password) {

        // Consulta SQL
        String sql = "SELECT * FROM USERS WHERE username = ? and pwd = ?";

        try(Connection conn = ConnDB.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setString(1, username);
            ps.setString(2, password);

            try(ResultSet rs = ps.executeQuery()){
                return rs.next();
            }

        } catch (Exception e) {
            //System.out.println(e.getMessage());
            LogWriter.create(e.getMessage());
            return false;
        }
    }

    // Obtener rol
    public int getRoleUser(String username){
        String sql = "SELECT id_role FROM USERS WHERE username = ?";

        try(Connection conn = ConnDB.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setString(1,username);

            // Obtener id del rol
            try(ResultSet rs = ps.executeQuery()){
                return rs.next()?rs.getInt("id_role"):0;
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public UserData getUserInfo(String username){

        String sql = "SELECT * FROM USERS WHERE username = ?";
        try(Connection conn = ConnDB.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setString(1,username);

            try(ResultSet rs = ps.executeQuery()){

                while (rs.next()){

                    //Datos
                    int id_user = rs.getInt("id_user");
                    String usernames = rs.getString("username");
                    String email = rs.getString("email");
                    String register_date = rs.getString("register_date");
                    int id_role = rs.getInt("id_role");
                    int is_banned = rs.getInt("banned");

                    UserData userData = new UserData(id_user,usernames,email,register_date,id_role,is_banned);

                    return userData;
                }
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }


    public static String getRoleName(int id_delRol){
        String sql = "SELECT * FROM ROLE WHERE id_role = ?";



        try(Connection conn = ConnDB.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setInt(1,id_delRol);

            // Obtener id del rol
            try(ResultSet rs = ps.executeQuery()){
                return rs.next()?rs.getString("NOMBRE_ROLE"):null;
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    // debug
    public void getUsers() {

        String sql = "SELECT * FROM USERS";

        try(Connection conn = ConnDB.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){

            while (rs.next()) {
                // Datos
                String username = rs.getString("username");
                String email = rs.getString("email");
                String pwd = rs.getString("pwd");
                int role = rs.getInt("id_role");

                // Usuario
                User user = new User(username, email, pwd, role);
                LogWriter.create(user.toString());

            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


}
