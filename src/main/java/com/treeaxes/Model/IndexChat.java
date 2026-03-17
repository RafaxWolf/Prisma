package com.treeaxes.Model;

public class IndexChat{

    private int id_user,indice;

    public IndexChat(int id_user, int indice) {
        this.id_user = id_user;
        this.indice = indice;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    @Override
    public String toString() {
        return "IndexChat{" +
                "id_user=" + id_user +
                ", indice=" + indice +
                '}';
    }

}
