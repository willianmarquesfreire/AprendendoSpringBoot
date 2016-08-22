package com.mycompany.springbootproject.domain;

import java.util.Date;

class Comentario {

    private Long id;

    private String texto;

    private String usuario;

    private Date data;

    public Comentario() {
    }

    public Comentario(Long id, String texto, String usuario, Date data) {
        this.id = id;
        this.texto = texto;
        this.usuario = usuario;
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

}
