package com.treeaxes.Model;

public class UserConversations extends User{

    private int id_user;

    public UserConversations(int id_user, String username) {
        super.setUsername(username);
        this.id_user = id_user;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    @Override
    public String toString() {
        return "UserConversations{" +
                "id_user=" + id_user +
                '}';
    }

}
