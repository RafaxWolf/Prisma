package com.treeaxes.Model;

public class Mensaje {

    private int id_mensaje,id_sender,id_receiver;
    private String fecha_mensaje;
    private String content_msg;

    public Mensaje() {
    }

    public Mensaje(int id_sender,int id_reciver, String fecha_mensaje,String content_msg) {
        this.id_sender = id_sender;
        this.id_receiver = id_reciver;
        this.fecha_mensaje = fecha_mensaje;
        this.content_msg = content_msg;
    }

    public Mensaje(int id_mensaje, int id_sender, int id_receiver, String fecha_mensaje, String content_msg) {
        this.id_mensaje = id_mensaje;
        this.id_sender = id_sender;
        this.id_receiver = id_receiver;
        this.fecha_mensaje = fecha_mensaje;
        this.content_msg = content_msg;
    }

    public int getId_mensaje() {
        return id_mensaje;
    }

    public int getId_sender() {
        return id_sender;
    }

    public int getId_receiver() {
        return id_receiver;
    }

    public String getFecha_mensaje() {
        return fecha_mensaje;
    }

    public String getContent_msg() {
        return content_msg;
    }

    public void setId_mensaje(int id_mensaje) {
        this.id_mensaje = id_mensaje;
    }

    public void setId_sender(int id_sender) {
        this.id_sender = id_sender;
    }

    public void setId_receiver(int id_receiver) {
        this.id_receiver = id_receiver;
    }

    public void setFecha_mensaje(String fecha_mensaje) {
        this.fecha_mensaje = fecha_mensaje;
    }

    public void setContent_msg(String content_msg) {
        this.content_msg = content_msg;
    }

    @Override
    public String toString() {
        return "Mensaje{" +
                "id_mensaje=" + id_mensaje +
                ", id_sender=" + id_sender +
                ", id_receiver=" + id_receiver +
                ", fecha_mensaje='" + fecha_mensaje + '\'' +
                ", content_msg='" + content_msg + '\'' +
                '}';
    }



}
