package com.treeaxes.Model;

import com.treeaxes.Controller.UserController;

public class UserData extends User{

    private int id_user;
    private String reg_date;
    private int banned;

    public UserData(int id_user, String username, String email, String reg_date, int id_role, int banned) {
        super(username,email,null,id_role);
        this.id_user = id_user;
        this.reg_date = reg_date;
        this.banned = banned;
    }

    public String getUsername() {
        return super.getUsername();
    }

    public String getEmail() {
        return super.getEmail();
    }

    public int getRole() {
        return super.getRole();
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getReg_date() {
        return reg_date;
    }

    public void setReg_date(String reg_date) {
        this.reg_date = reg_date;
    }

    public int getBanned() {
        return banned;
    }

    public void setBanned(int banned) {
        this.banned = banned;
    }


    @Override
    public String toString() {
        return "User " + getUsername() + "\n" +
                "Id de Usuario " + getId_user()+"\n" +
                "Correo de Usuario: " + getEmail()+"\n" +
                "Fecha de Registro de usuario: " + getReg_date()+"\n" +
                "Rol del usuario: " + UserController.getRoleName(getRole())+"\n" +
                "Baneado: " + (getBanned() == 1 ? "Sí" : "No") + "\n";
    }
}
