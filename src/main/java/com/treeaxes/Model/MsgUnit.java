package com.treeaxes.Model;

public class MsgUnit {

    private String emisor,content,fecha;

    public MsgUnit(String emisor, String content, String fecha) {
        this.emisor = emisor;
        this.content = content;
        this.fecha = fecha;
    }

    public String getEmisor() {
        return emisor;
    }

    public String getContent() {
        return content;
    }

    public String getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        return "MsgUnit{" +
                "emisor='" + emisor + '\'' +
                ", content='" + content + '\'' +
                ", fecha='" + fecha + '\'' +
                '}';
    }

}
